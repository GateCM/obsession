/**
 * 
 */
package com.gatecm.obsession.sms;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gatecm.obsession.sms.vcode.MD5Gen;
import com.gatecm.obsession.sms.vcode.VCodeBean;
import com.gatecm.obsession.sms.vcode.VcodeEnum;
import com.gatecm.obsession.util.HttpRequestUtils;
import com.gatecm.obsession.util.TimeUtils;

/**
 * @Description: TODO(短信发送)
 * @author chenxiaohui
 * @date 2017年4月25日 下午3:13:50
 *
 */
public class SMSManager {
	private final Logger log = LoggerFactory.getLogger(SMSManager.class);

	private static final String USER_NAME = "&username=yilvhy";
	private static final String PASSWORD = "boWEZs";
	private static final String URL = "http://www.api.zthysms.com/sendSms.do";
	private static final String XH_PARAM_NAME = "&xh";
	private static final String PASSWORD_PARAM_NAME = "&password=";
	private static final String TKEY_PARAM_NAME = "&tkey=";
	private static final String MOBILE_PARAM_NAME = "&mobile=";
	private static final String VCODE_CONTENT_PARAM_NAME = "&content=";
	private static final String SMS_CONTENT_ENCODING = "utf-8";
	private static final String TIME_FORMAT = "yyyyMMddHHmmss";

	private static final String SEPARATOR = ",";
	private static final String SEND_SUCCESS = "1";// 成功标志

	private static final Long SEND_INTERVAL = 1L;// 发送间隔，单位 min
	private static final Long OVERDUE_TIME = 5L;// 验证码过期时间，单位 min

	private Map<String, VCodeBean> phoneNumberVCodeMap = new HashMap<>();

	private static SMSManager vcodeManage = new SMSManager();

	private SMSManager() {
	}

	public static SMSManager getInstance() {
		return vcodeManage;
	}

	/**
	 * 发送并跟踪验证码
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public boolean sendVCodeSMS(String phoneNumber) {
		Date current = new Date();
		// 判断手机号对应验证码状态
		VCodeBean vCodeBean = phoneNumberVCodeMap.get(phoneNumber);
		if (vCodeBean == null || vCodeBean.getInterval(current) >= SEND_INTERVAL) {
			// 生成验证码
			String vcode = createRandomVcode();
			// 发送验证码
			if (sendVCodeSMS(phoneNumber, vcode)) {
				// 建立手机号验证码映射
				phoneNumberVCodeMap.put(phoneNumber, new VCodeBean(vcode, current));
				log.info("==发送验证码成功," + phoneNumber + SEPARATOR + vcode);
				return true;
			}
		}
		return false;
	}

	/**
	 * 发送短信,自动补全短信签名
	 * 
	 * @param phoneNumber
	 * @param content
	 * @return
	 */
	public boolean sendSMSWithSign(String phoneNumber, String content) {
		return sendSMS(phoneNumber, EnumSMSTemplate.SIGN.getValue() + content);
	}

	/**
	 * 发送短信
	 * 
	 * @param phoneNumber
	 * @param content
	 * @return
	 */
	public boolean sendSMS(String phoneNumber, String content) {
		String tkey = TimeUtils.getNowTime(TIME_FORMAT);
		String password = MD5Gen.getMD5(MD5Gen.getMD5(PASSWORD) + tkey);
		StringBuilder sbBuffer = new StringBuilder();
		sbBuffer.append(USER_NAME);
		sbBuffer.append(PASSWORD_PARAM_NAME);
		sbBuffer.append(password);
		sbBuffer.append(TKEY_PARAM_NAME);
		sbBuffer.append(tkey);
		sbBuffer.append(MOBILE_PARAM_NAME);
		sbBuffer.append(phoneNumber);
		sbBuffer.append(VCODE_CONTENT_PARAM_NAME);
		try {
			sbBuffer.append(URLEncoder.encode(content, SMS_CONTENT_ENCODING));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			log.error("短信内容转码失败！", e.getMessage());
			return false;
		}
		sbBuffer.append(XH_PARAM_NAME);
		String ret = HttpRequestUtils.sendPost(URL, sbBuffer.toString());
		log.info("==短信发送内容: " + sbBuffer.toString() + "&短信发送结果: " + ret);
		return ret.split(SEPARATOR)[0].equals(SEND_SUCCESS);
	}

	/**
	 * 发送验证码短信
	 * 
	 * @param phoneNumber
	 * @param vcode
	 * @return
	 */
	private boolean sendVCodeSMS(String phoneNumber, String vcode) {
		String vcodeContent = EnumSMSTemplate.SIGN.getValue() + EnumSMSTemplate.VOCDE_REGISTER.getValue() + vcode;
		return sendSMS(phoneNumber, vcodeContent);
	}

	/**
	 * 验证码生成
	 * 
	 * @return
	 */
	private static String createRandomVcode() {
		String vcode = "";
		for (int i = 0; i < 6; i++) {
			vcode = vcode + (int) (Math.random() * 9);
		}
		return vcode;
	}

	/**
	 * 获取手机号对应验证码发送时间
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public Date getVCodeSendTime(String phoneNumber) {
		VCodeBean vCodeBean = phoneNumberVCodeMap.get(phoneNumber);
		if (vCodeBean != null) {
			return vCodeBean.getSendDate();
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @param phoneNumber
	 * @param vcode
	 * @return 0:验证码错误；2：验证码超时；1：验证通过
	 */
	public VcodeEnum validation(String phoneNumber, String vcode) {
		VcodeEnum flag;
		VCodeBean vCodeBean = phoneNumberVCodeMap.get(phoneNumber);
		if (vCodeBean != null && vCodeBean.getVcode().equals(vcode)) {
			if (vCodeBean.getInterval(new Date()) < OVERDUE_TIME) {
				flag = VcodeEnum.VCODE_CORRECT;
			} else {
				flag = VcodeEnum.VCODE_TIME_OUT;
			}
		} else {
			flag = VcodeEnum.VCODE_ERROR;
		}
		return flag;
	}

	/**
	 * 根据手机号移除验证码
	 * 
	 * @param phoneNumber
	 */
	public void removeVcodeByPhoneNumber(String phoneNumber) {
		phoneNumberVCodeMap.remove(phoneNumber);
	}
}
