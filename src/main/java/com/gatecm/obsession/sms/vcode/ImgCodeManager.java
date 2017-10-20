/**
 * 
 */
package com.gatecm.obsession.sms.vcode;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

/**
 * @Description: TODO(图片验证码处理器)
 * @author chenxiaohui
 * @date 2017年10月20日 上午11:31:10
 *
 */
public class ImgCodeManager {

	private Map<String, VCodeBean> phoneNumberImgCodeMap = new HashMap<>();

	private static ImgCodeManager imgCodeManager = new ImgCodeManager();

	private ImgCodeManager() {
	}

	public static ImgCodeManager getInstance() {
		return imgCodeManager;
	}

	/**
	 * 保存手机号图片验证码映射
	 * 
	 * @param phoneNumber
	 * @param imgCode
	 */
	public void saveImgCode(String phoneNumber, String imgCode) {
		phoneNumberImgCodeMap.put(phoneNumber, new VCodeBean(imgCode, new Date()));
	}

	/**
	 * 验证图片验证码
	 * 
	 * @param phoneNumber
	 * @param imgCode
	 * @return
	 */
	public VcodeEnum validation(String phoneNumber, String imgCode) {
		if (StringUtils.isEmpty(imgCode)) {
			return VcodeEnum.VCODE_ERROR;
		}
		VCodeBean imgCodebean = phoneNumberImgCodeMap.get(phoneNumber);
		if (imgCodebean != null && imgCode.equals(imgCodebean.getVCode())) {
			phoneNumberImgCodeMap.remove(phoneNumber);// 移除
			return VcodeEnum.VCODE_CORRECT;
		} else {
			return VcodeEnum.VCODE_ERROR;
		}
	}
}
