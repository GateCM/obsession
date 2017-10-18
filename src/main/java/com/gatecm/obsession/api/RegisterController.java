/**
 * 
 */
package com.gatecm.obsession.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gatecm.obsession.controller.DemoController;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年10月18日 下午3:38:42
 *
 */
@RestController
@RequestMapping(value = "/register")
public class RegisterController {

	// @Autowired
	// private UserService userService;

	private static final Logger log = LoggerFactory.getLogger(RegisterController.class);

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		log.info(DemoController.class.getSimpleName() + "==index test");

		// User user = userService.selectById(1L);
		// System.err.println(user.getNickname());
		// System.err.println("===================");
		// modelAndView.addObject("a", user);
		modelAndView.setViewName("portals/index");
		return modelAndView;
	}

}
