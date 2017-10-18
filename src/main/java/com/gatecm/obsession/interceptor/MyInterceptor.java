/**
 * 
 */
package com.gatecm.obsession.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年10月11日 上午10:14:08
 *
 */
public class MyInterceptor implements HandlerInterceptor {

	private static final Logger log = LoggerFactory.getLogger(MyInterceptor.class);

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info(MyInterceptor.class.getSimpleName() + "==>preHandle: " + "preHandle:URI [" + request.getRequestURI()
				+ "], Request Mapping [" + handler + "]");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
