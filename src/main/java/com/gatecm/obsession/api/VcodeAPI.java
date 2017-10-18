/**
 * 
 */
package com.gatecm.obsession.api;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gatecm.obsession.constant.EnumResponseParam;
import com.gatecm.obsession.error.APIErrorEnum;
import com.gatecm.obsession.error.ErrorUtils;
import com.gatecm.obsession.service.ResultEntity;
import com.gatecm.obsession.service.VcodeService;

/**
 * @Description: TODO(验证码接口)
 * @author chenxiaohui
 * @date 2017年10月18日 下午4:42:28
 *
 */
@RestController
@RequestMapping(value = "/vcode")
public class VcodeAPI {
	@Autowired
	private VcodeService vcodeService;

	// 验证码发送
	@RequestMapping(value = "/sendSMS", method = RequestMethod.GET)
	public Map<String, Object> sendSMS(String phoneNumber) {
		Map<String, Object> map = new HashMap<>();
		boolean result = vcodeService.sendSMS(phoneNumber);
		if (!result) {
			Date sendTime = vcodeService.getSendTime(phoneNumber);
			if (sendTime != null) {
				map.put(EnumResponseParam.VCODE_SEND_TIME.getValue(), sendTime);
				map.put(EnumResponseParam.ERROR.getValue(), ErrorUtils.apiError(APIErrorEnum.VCODE_REQUEST_WAIT));
			} else {
				map.put(EnumResponseParam.ERROR.getValue(), ErrorUtils.apiError(APIErrorEnum.UNKNOWN_ERROR));
			}
		}
		map.put(EnumResponseParam.RESULT.getValue(), result);
		return map;
	}

	// 验证码判断
	@RequestMapping(value = "/validation", method = RequestMethod.GET)
	public Map<String, Object> validation(String phoneNumber, String vcode) {
		Map<String, Object> map = new HashMap<>();
		ResultEntity resultEntity = vcodeService.validation(phoneNumber, vcode);
		if (!resultEntity.isSuccess()) {
			map.put(EnumResponseParam.ERROR.getValue(), resultEntity.getError());
		}
		map.put(EnumResponseParam.RESULT.getValue(), resultEntity.isSuccess());
		return map;
	}

}
