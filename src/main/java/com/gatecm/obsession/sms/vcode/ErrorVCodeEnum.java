package com.gatecm.obsession.sms.vcode;

/**
 * @Description: TODO(验证码错误码)
 * @author chenxiaohui
 * @date 2017年4月30日 下午15:13:50
 *
 */
public enum ErrorVCodeEnum {

	VCODE_SMS_INCORRECT(10011, "验证码错误, 请重新输入"), // 验证阶段

	VCODE_SMS_TIME_OUT(10012, "该验证码已过期, 请重新获取"),

	VCODE_REQUST_SMS_WAIT(10013, "验证码请求过于频繁"),

	VCODE_REQUST_IMG_INCORRECT(10014, "图形验证码错误, 请重新输入"),

	VCODE_REQUST_SMS_SEND_FAIL(10015, "短信发送失败");// 平台问题

	private String msg;
	private int code;

	private ErrorVCodeEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getMsg() {
		return this.msg;
	}

	public int getCode() {
		return this.code;
	}
}
