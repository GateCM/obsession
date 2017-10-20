/**
 * 
 */
package com.gatecm.obsession.constant;

/**
 * @Description: TODO(响应参数名定义)
 * @author chenxiaohui
 * @date 2017年10月20日 下午3:01:05
 *
 */
public enum EnumResponseParam {

	/**
	 * 1.商户手机号是否注册
	 */
	IS_EXIST("isExist"),

	/**
	 * 错误
	 */
	ERROR("error"),

	/**
	 * 短信是否发送
	 */
	SMS_IS_SEND("isSend"),

	/**
	 * 验证码发送时间
	 */
	VCODE_SMS_SEND_TIME("vcodeSendTime"),

	/**
	 * 验证码发送次数
	 */
	VCODE_SMS_SEND_NUMBER("vcodeSendNum"),

	TOKEN("token");

	String value;

	private EnumResponseParam(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
