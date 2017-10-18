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
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import com.gatecm.obsession.entity.Member;
import com.gatecm.obsession.entity.SysPermission;
import com.gatecm.obsession.mapper.MemberDao;
import com.gatecm.obsession.mapper.SysPermissionDao;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年10月16日 上午9:50:17
 *
 */
@Repository
public class BasicRealm extends AuthorizingRealm {

	@Autowired
	private MemberDao memberDao;

	@Autowired
	private SysPermissionDao sysPermissionDao;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("权限认证方法：MyShiroRealm.doGetAuthenticationInfo()");
		Member member = (Member) SecurityUtils.getSubject().getPrincipal();
		Long memberId = member.getId();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		List<SysPermission> permissionList = sysPermissionDao.findByMemberId(memberId);
		Set<String> permissionSet = new HashSet<>();
		for (SysPermission Permission : permissionList) {
			permissionSet.add(Permission.getUrl());
		}
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
		List<Member> users = memberDao.selectByMap(columnMap);
		Member user;
		if (CollectionUtils.isEmpty(users)) {
			throw new AccountException("帐号或密码不正确！");
		} else {
			user = users.get(0);
		}
		return new SimpleAuthenticationInfo(user, user.getPswd(), ByteSource.Util.bytes(user.getSalt()), getName());
	}

}
