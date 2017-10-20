/**
 * 
 */
package com.gatecm.obsession.service;

import java.util.Date;

/**
 * @Description: TODO(验证码)
 * @author chenxiaohui
 * @date 2017年4月26日 下午7:54:51
 *
 */
public interface VcodeService {

	// 短信验证码发送
	ResultEntity sendSMS(String phoneNumber, String imgCode);

	// 获取验证码发送时间
	Date getSendTime(String phoneNumber);

	// 短信验证码验证
	ResultEntity validation(String phoneNumber, String vcode);
}
