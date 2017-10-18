/**
 * 
 */
package com.gatecm.obsession.service;

import com.gatecm.obsession.error.ErrorEntity;

/**
 * @Description: TODO(复杂业务方法返回值封装类)
 * @author chenxiaohui
 * @date 2017年5月3日 上午10:47:08
 *
 */
public class ResultEntity {
	boolean result;// 操作结果，成功|失败
	Object value;// 返回值
	Object supplyValue;// 补充返回值,当value不能满足需求是使用，尽量减少使用
	ErrorEntity error;// 错误码

	public ResultEntity() {

	}

	
	
	public boolean isResult() {
		return result;
	}



	public void setResult(boolean result) {
		this.result = result;
	}



	public ResultEntity(boolean result) {
		this.result = result;
	}

	public boolean isSuccess() {
		return result;
	}

	public void setSuccess(boolean result) {
		this.result = result;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public ErrorEntity getError() {
		return error;
	}

	public void setError(ErrorEntity error) {
		this.error = error;
	}

	public Object getSupplyValue() {
		return supplyValue;
	}

	public void setSupplyValue(Object supplyValue) {
		this.supplyValue = supplyValue;
	}

}
