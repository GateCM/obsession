package com.gatecm.obsession.mapper;

import com.gatecm.obsession.entity.Member;

import io.lettuce.core.dynamic.annotation.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 商户信息表 Mapper 接口
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-10-17
 */
public interface MemberDao extends BaseMapper<Member> {

	/**
	 * 根据注册手机号获取用户信息
	 * 
	 * @param phoneNumber
	 * @return
	 */
	Member selectByPhoneNumber(@Param("phoneNumber")String phoneNumber);

}