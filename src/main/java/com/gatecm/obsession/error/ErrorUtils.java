/**
 * 
 */
package com.gatecm.obsession.error;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年4月28日 上午11:45:03
 *
 */
public class ErrorUtils {

	public static ErrorEntity apiError(APIErrorEnum apiError) {
		return new ErrorEntity(apiError.getCode(), apiError.getMsg());
	}

	public static ErrorEntity apiError(int code, String msg) {
		return new ErrorEntity(code, msg);
	}

}
