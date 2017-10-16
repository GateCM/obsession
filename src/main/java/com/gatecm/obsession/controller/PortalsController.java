/**
 * 
 */
package com.gatecm.obsession.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年10月12日 下午1:18:41
 *
 */
@Controller
@RequestMapping(value = "/portals")
public class PortalsController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();

		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();

		System.err.println(session.getHost());
		System.err.println(session.getId());

		modelAndView.addObject("test", "hello");
		modelAndView.setViewName("portals/index");
		return modelAndView;
	}

	@RequestMapping(value = "/ethereal", method = RequestMethod.GET)
	public ModelAndView etherealIndex() {
		ModelAndView modelAndView = new ModelAndView();

		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		
		if (subject.hasRole("供应商")) {
			modelAndView.setViewName("ethereal/index");
		} else {
			modelAndView.setViewName("portals/index");
		}
		modelAndView.addObject("test", "hello");
		return modelAndView;
	}

}
