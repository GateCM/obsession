package com.gatecm.obsession.mapper;

import com.gatecm.obsession.dto.ModelTreeDTO;
import com.gatecm.obsession.entity.SysModel;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 系统模型表 Mapper 接口
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-10-17
 */
public interface SysModelDao extends BaseMapper<SysModel> {

	List<ModelTreeDTO> getModelTreesByMemberId(@Param("memberId") Long memberId);

}