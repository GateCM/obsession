package com.gatecm.obsession.service;

import com.gatecm.obsession.dto.ModelTreeDTO;
import com.gatecm.obsession.entity.Member;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 商户信息表 服务类
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-10-17
 */
public interface MemberService extends IService<Member> {

	/**
	 * 根据手机号获取模型树（菜单树）
	 * 
	 * @param phoneNumber
	 * @return
	 */
	ModelTreeDTO getModelTreeByPhoneNumber(String phoneNumber);

	/**
	 * 根据用户ID获取模型树（菜单树）
	 * 
	 * @param memberId
	 * @return
	 */
	ModelTreeDTO getModelTreeBymemberId(Long memberId);

}
