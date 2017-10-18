package com.gatecm.obsession.mapper;

import com.gatecm.obsession.entity.SysPermission;

import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 系统权限表 Mapper 接口
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-10-17
 */
public interface SysPermissionDao extends BaseMapper<SysPermission> {

	/**
	 * @param memberId
	 * @return
	 */
	List<SysPermission> findByMemberId(@Param("memberId") Long memberId);

}