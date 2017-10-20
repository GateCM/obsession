package com.gatecm.obsession.sms.vcode;

/**
 * @Description: TODO(验证码常量)
 * @author chenxiaohui
 * @date 2017年10月20日 下午6:19:08
 *
 */
public enum VcodeEnum {

	VCODE_ERROR("0"),

	VCODE_TIME_OUT("2"),

	VCODE_CORRECT("1");

	private String value;

	private VcodeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
