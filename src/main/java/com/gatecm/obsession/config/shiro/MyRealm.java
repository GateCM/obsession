/**
 * 
 */
package com.gatecm.obsession.config.shiro;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import com.gatecm.obsession.entity.User;
import com.gatecm.obsession.mapper.UserDao;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年10月16日 上午9:50:17
 *
 */
@Repository
public class MyRealm extends AuthorizingRealm {

	@Autowired
	private UserDao userDao;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("权限认证方法：MyShiroRealm.doGetAuthenticationInfo()");
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		Long userId = user.getId();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 根据用户ID查询角色（role），放入到Authorization里。
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("user_id", userId);
//		List<SysRole> roleList = sysRoleService.selectByMap(map);
//		Set<String> roleSet = new HashSet<String>();
//		for (SysRole role : roleList) {
//			roleSet.add(role.getType());
//		}
		// 实际开发，当前登录用户的角色和权限信息是从数据库来获取的
		Set<String> roleSet = new HashSet<String>();
		roleSet.add("供应商");
		info.setRoles(roleSet);
		// 根据用户ID查询权限（permission），放入到Authorization里。
		/*
		 * List<SysPermission> permissionList =
		 * sysPermissionService.selectByMap(map); Set<String> permissionSet =
		 * new HashSet<String>(); for(SysPermission Permission :
		 * permissionList){ permissionSet.add(Permission.getName()); }
		 */
		Set<String> permissionSet = new HashSet<String>();
		permissionSet.add("/portals/ethereal");
		info.setStringPermissions(permissionSet);
		return info;
	}

	/**
	 * 认证信息.(身份验证) : Authentication 是用来验证用户身份
	 * 
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		System.out.println("身份认证方法：MyShiroRealm.doGetAuthenticationInfo()");
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		Map<String, Object> columnMap = new HashMap<String, Object>();
		columnMap.put("nickname", token.getUsername());
		List<User> users = userDao.selectByMap(columnMap);
		User user;
		if (CollectionUtils.isEmpty(users)) {
			throw new AccountException("帐号或密码不正确！");
		} else {
			user = users.get(0);
		}
		return new SimpleAuthenticationInfo(user, user.getPswd(), getName());
	}

}
