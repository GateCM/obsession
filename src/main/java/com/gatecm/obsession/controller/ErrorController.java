/**
 * 
 */
package com.gatecm.obsession.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.UpdatableSqlQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年10月18日 下午1:31:07
 *
 */
@Controller
@RequestMapping(value = "/error")
public class ErrorController {

	private static final Logger log = LoggerFactory.getLogger(ErrorController.class);

	@RequestMapping(value = "/nopermission", method = RequestMethod.GET)
	public ModelAndView noPermission() {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("error/no_permission");
		return modelAndView;
	}
	
	@RequestMapping(value = "/unauthorized", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> unauthorized() {
		Map<String, Object> map = new HashMap<>();
		map.put("result", 300);
		return map;
	}

}
