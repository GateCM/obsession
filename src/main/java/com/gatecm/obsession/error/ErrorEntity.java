/**
 * 
 */
package com.gatecm.obsession.error;

/**
 * @Description: TODO(错误实体)
 * @author chenxiaohui
 * @date 2017年4月28日 上午11:44:32
 *
 */
public class ErrorEntity {
	int code;
	String msg;

	public ErrorEntity(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
