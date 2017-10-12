/**
 * 
 */
package com.gatecm.obsession.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.gatecm.obsession.interceptor.MyInterceptor;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年10月11日 上午10:23:59
 *
 */
@Configuration
public class MVCConfiguration extends WebMvcConfigurerAdapter {

	/**
	 * 拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// addPathPatterns 用于添加拦截规则
		// excludePathPatterns 用于排除拦截
		registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/error", "/error");
		super.addInterceptors(registry);
	}

}
