/**
 * 
 */
package com.gatecm.obsession.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.gatecm.obsession.error.APIErrorEnum;
import com.gatecm.obsession.error.ErrorEntity;
import com.gatecm.obsession.error.ErrorUtils;
import com.gatecm.obsession.service.ResultEntity;
import com.gatecm.obsession.service.VcodeService;
import com.gatecm.obsession.sms.SMSManager;
import com.gatecm.obsession.sms.vcode.ErrorVCodeEnum;
import com.gatecm.obsession.sms.vcode.VCodeBean;
import com.gatecm.obsession.sms.vcode.VcodeEnum;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年4月26日 下午7:57:05
 * 
 */
@Service("vcodeService")
public class VcodeServiceImpl implements VcodeService {

	@Override
	public ResultEntity sendSMS(String phoneNumber, String imgCode) {
		ResultEntity resultEntity = new ResultEntity(false);
		boolean isSendSuccess = SMSManager.getInstance().sendVCodeSMSWithTrack(phoneNumber, imgCode);
		VCodeBean codeBean = SMSManager.getInstance().getVCodeBean(phoneNumber);
		if (isSendSuccess) {
			resultEntity.setSuccess(true);
		} else {
			ErrorVCodeEnum errorCode = codeBean.getErrorCode();
			ErrorEntity errorEntity = new ErrorEntity(errorCode.getCode(), errorCode.getMsg());
			resultEntity.setError(errorEntity);
		}
		resultEntity.setValue(codeBean);// 返回短信实体
		return resultEntity;
	}

	@Override
	public Date getSendTime(String phoneNumber) {
		return SMSManager.getInstance().getVCodeSendTime(phoneNumber);
	}

	@Override
	public ResultEntity validation(String phoneNumber, String vcode) {
		ResultEntity resultEntity = new ResultEntity();
		boolean flag = false;
		if (!"".equals(vcode)) {
			VcodeEnum vcodeEnum = SMSManager.getInstance().validation(phoneNumber, vcode);
			switch (vcodeEnum) {
			case VCODE_CORRECT:
				flag = true;
				break;
			case VCODE_TIME_OUT:
				resultEntity.setError(ErrorUtils.apiError(APIErrorEnum.VCODE_TIME_OUT));
				break;
			case VCODE_ERROR:
				resultEntity.setError(ErrorUtils.apiError(APIErrorEnum.VCODE_ERROR));
				break;
			default:
				break;
			}
		}
		resultEntity.setSuccess(flag);
		return resultEntity;
	}
}
