package com.gatecm.obsession.sms;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.gatecm.obsession.sms.vcode.ErrorVCodeEnum;
import com.gatecm.obsession.sms.vcode.ImgCodeManager;
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

	private static final int SEND_TIMES_MAX = 4;// 短信发送临界值，超过5次则使用图形验证码
	private static final Long SEND_INTERVAL = 0L;// 发送间隔，单位 min
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
	public boolean sendVCodeSMSWithTrack(String phoneNumber, String imgCode) {
		Date current = new Date();
		VCodeBean vCodeBean = phoneNumberVCodeMap.get(phoneNumber);
		// 首次发送
		if (vCodeBean == null) {
			vCodeBean = new VCodeBean();
			vCodeBean.setSendTimes(0);
			phoneNumberVCodeMap.put(phoneNumber, vCodeBean);
		}
		// 再次发送，判断请求间隔
		if (vCodeBean.getInterval(current) < SEND_INTERVAL) {
			vCodeBean.setErrorCode(ErrorVCodeEnum.VCODE_REQUST_SMS_WAIT);
			return false;
		}

		// 判断请求次数和图形验证码是否正确
		if (vCodeBean.getSendTimes() > SEND_TIMES_MAX
				&& !ImgCodeManager.getInstance().validation(phoneNumber, imgCode).equals(VcodeEnum.VCODE_CORRECT)) {
			vCodeBean.setErrorCode(ErrorVCodeEnum.VCODE_REQUST_IMG_INCORRECT);
			return false;
		}
		// 生成验证码
		String vcode = createRandomVcode();
		// 发送验证码
		if (sendVCodeSMS(phoneNumber, vcode)) {
			vCodeBean.setSendDate(current);
			vCodeBean.setVCode(vcode);
			// 增加短信发送次数
			vCodeBean.addSendTimes();
			log.info("==发送验证码成功," + phoneNumber + SEPARATOR + vcode);
			return true;
		} else {
			vCodeBean.setErrorCode(ErrorVCodeEnum.VCODE_REQUST_SMS_SEND_FAIL);
			return false;
		}
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
	 * 短信验证码验证
	 * 
	 * @param phoneNumber
	 * @param vcode
	 * @return
	 */
	public VcodeEnum validation(String phoneNumber, String vCode) {
		if (StringUtils.isEmpty(vCode)) {
			return VcodeEnum.VCODE_ERROR;
		}
		VCodeBean vCodeBean = phoneNumberVCodeMap.get(phoneNumber);
		if (vCodeBean != null && vCode.equals(vCodeBean.getVCode())) {
			if (vCodeBean.getInterval(new Date()) < OVERDUE_TIME) {
				return VcodeEnum.VCODE_CORRECT;
			} else {
				return VcodeEnum.VCODE_TIME_OUT;
			}
		} else {
			return VcodeEnum.VCODE_ERROR;
		}
	}

	/**
	 * 根据手机号移除验证码
	 * 
	 * @param phoneNumber
	 */
	public void removeVcodeByPhoneNumber(String phoneNumber) {
		phoneNumberVCodeMap.remove(phoneNumber);
	}

	/**
	 * 获取短信发送实体
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public VCodeBean getVCodeBean(String phoneNumber) {
		return phoneNumberVCodeMap.get(phoneNumber);
	}
}
