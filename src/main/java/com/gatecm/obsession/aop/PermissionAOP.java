/**
 * 
 */
package com.gatecm.obsession.aop;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gatecm.obsession.entity.Member;
import com.gatecm.obsession.service.MemberService;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年10月17日 下午1:20:19
 *
 */
@Component
@Aspect
public class PermissionAOP {
	private static final String CURRENT_MODEL_KEY = "currentModel";
	private static final String MODEL_TREE_ROOT_KEY = "modelRoot";

	@Autowired
	private MemberService memberService;

	// 匹配com.gatecm.obsession.controller包及其子包下的所有类的所有方法
	// @Pointcut("execution(* com.gatecm.obsession.controller..*.*(..))")
	// public void executeService() {
	//
	// }

	/**
	 * 后置返回通知 这里需要注意的是: 如果参数中的第一个参数为JoinPoint，则第二个参数为返回值的信息
	 * 如果参数中的第一个参数不为JoinPoint，则第一个参数为returning中对应的参数 returning
	 * 限定了只有目标方法返回值与通知方法相应参数类型时才能执行后置返回通知，否则不执行，对于returning对应的通知方法参数为Object类型将匹配任何目标返回值
	 * 
	 * @param joinPoint
	 * @param keys
	 */
	@SuppressWarnings("unchecked")
	@AfterReturning(value = "execution(* com.gatecm.obsession.controller..*.*(..))", returning = "keys")
	public void doAfterReturningAdvice1(JoinPoint joinPoint, Object keys) {
		if (keys instanceof Map) {
			Member user = (Member) SecurityUtils.getSubject().getPrincipal();
			Map<String, Object> map = (Map<String, Object>) keys;
			map.put(CURRENT_MODEL_KEY, getCurrentModelValue());
			map.put(MODEL_TREE_ROOT_KEY, memberService.getModelTreeBymemberId(user.getId()));
			System.out.println("第一个后置返回通知的返回值：" + keys);
		}
	}

	private String getCurrentModelValue() {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();
		return request.getParameter(CURRENT_MODEL_KEY);
	}

}
