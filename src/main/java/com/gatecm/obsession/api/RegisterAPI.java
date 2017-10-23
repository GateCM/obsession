package com.gatecm.obsession.api;

import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gatecm.obsession.constant.EnumResponseParam;
import com.gatecm.obsession.service.ResultEntity;
import com.gatecm.obsession.service.VcodeService;
import com.gatecm.obsession.sms.vcode.ImgCodeGenerator;
import com.gatecm.obsession.sms.vcode.ImgCodeManager;
import com.gatecm.obsession.sms.vcode.VCodeBean;

/**
 * @Description: TODO(注册相关接口)
 * @author chenxiaohui
 * @date 2017年10月16日 下午2:06:50
 *
 */
@RestController
@RequestMapping(value = "/reg")
public class RegisterAPI {

	@Autowired
	private VcodeService vcodeService;

//	@Autowired
	// private UcMemberService ucMemberService;

	/**
	 * 验证手机号是否注册
	 * 
	 * @param mobile
	 * @return
	 */
	@RequestMapping(value = "/mobile/verify", method = RequestMethod.GET)
	public Map<String, Object> mobileVerify(String mobile) {
		Map<String, Object> map = new HashMap<>();
		// ResultEntity result = ucMemberService.isMobileRegistered(mobile);
		// map.put(EnumResponseParam.IS_EXIST.getValue(), result.getValue());
		return map;
	}

	/**
	 * 发送短信验证码
	 * 
	 * @param mobile
	 * @param imgCode
	 *            可选参数
	 * @return
	 */
	@RequestMapping(value = "/sms/vcode", method = RequestMethod.GET)
	public Map<String, Object> sendSMS(String mobile, String imgCode) {
		Map<String, Object> map = new HashMap<>();
		boolean isSend = false;
		ResultEntity resultEntity = vcodeService.sendSMS(mobile, imgCode);
		VCodeBean codeBean = (VCodeBean) resultEntity.getValue();
		map.put(EnumResponseParam.VCODE_SMS_SEND_TIME.getValue(), codeBean.getSendDate());
		map.put(EnumResponseParam.VCODE_SMS_SEND_NUMBER.getValue(), codeBean.getSendTimes());
		if (resultEntity.isSuccess()) {
			isSend = true;
		} else {
			map.put(EnumResponseParam.ERROR.getValue(), resultEntity.getError());
		}
		map.put(EnumResponseParam.SMS_IS_SEND.getValue(), isSend);
		return map;
	}

	/**
	 * 发送图片验证码
	 * 
	 * @param mobile
	 * @return
	 */
	@RequestMapping(value = "/img/vcode", method = RequestMethod.GET)
	public void sendSMS(String mobile, HttpServletResponse response) {
		ImgCodeGenerator imgCode = new ImgCodeGenerator(160, 40, 5, 150);
		ImgCodeManager.getInstance().saveImgCode(mobile, imgCode.getCode());
		try {
			ImageIO.write(imgCode.getBuffImg(), "JPEG", response.getOutputStream());
			response.getOutputStream().flush();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	/**
	 * 根据手机号注册用户
	 * 
	 * @param phoneNumber
	 * @param vcode
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/commit", method = RequestMethod.POST)
	public Map<String, Object> commit(String vcode) {
		Map<String, Object> map = new HashMap<>();
		// ResultEntity resultEntity =
		// ucUserService.registerByVcode(phoneNumber, password, vcode);
		// if (!resultEntity.isSuccess()) {
		// map.put(EnumResponseParam.ERROR.getValue(), resultEntity.getError());
		// }
		// map.put(EnumResponseParam.RESULT.getValue(),
		// resultEntity.isSuccess());
		return map;
	}

}
