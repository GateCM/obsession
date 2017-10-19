///**
// * 
// */
//package com.gatecm.obsession.api;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.gatecm.obsession.constant.EnumResponseParam;
//import com.gatecm.obsession.controller.DemoController;
//import com.gatecm.obsession.service.MemberService;
//import com.gatecm.obsession.service.ResultEntity;
//
///**
// * @Description: TODO()
// * @author chenxiaohui
// * @date 2017年10月18日 下午3:38:42
// *
// */
//@RestController
//@RequestMapping(value = "/register")
//public class RegisterController {
//
//	@Autowired
//	private MemberService memberService;
//
//	/**
//	 * 验证手机号是否注册
//	 * 
//	 * @param phoneNumber
//	 * @return
//	 */
//	@RequestMapping(value = "/reg/pn", method = RequestMethod.GET)
//	public Map<String, Object> registeredPhoneNumber(String phoneNumber) {
//		Map<String, Object> map = new HashMap<>();
//		boolean result = memberService.isPhoneNumberRegistered(phoneNumber);
//		map.put(EnumResponseParam.RESULT.getValue(), result);
//		return map;
//	}
//
//	// 注册用户
//	@RequestMapping(value = "/reg", method = RequestMethod.POST)
//	public Map<String, Object> register(String phoneNumber, String vcode, String password) {
//		Map<String, Object> map = new HashMap<>();
//		ResultEntity resultEntity = memberService.registerByVcode(phoneNumber, password, vcode);
//		if (!resultEntity.isSuccess()) {
//			map.put(EnumResponseParam.ERROR.getValue(), resultEntity.getError());
//		}
//		map.put(EnumResponseParam.RESULT.getValue(), resultEntity.isSuccess());
//		return map;
//	}
//
//}
