/**
 * 
 */
package com.gatecm.obsession.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.UpdatableSqlQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.sql.visitor.functions.Ucase;
import com.gatecm.obsession.entity.User;
import com.gatecm.obsession.service.UserService;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年10月11日 上午9:52:07
 *
 */
@Controller
@RequestMapping(value = "/index")
public class DemoController {

	@Autowired
	private UserService userService;

	private static final Logger log = LoggerFactory.getLogger(DemoController.class);

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		log.info(DemoController.class.getSimpleName() + "==index test");

		userService.test();
		User user = userService.selectById(9L);
		System.err.println(user.getNickname());
		System.err.println("===================");
		modelAndView.addObject("a", user);
		modelAndView.setViewName("portals/index");
		return modelAndView;
	}

}
