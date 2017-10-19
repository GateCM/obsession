package com.gatecm.obsession.service.impl;

import com.gatecm.obsession.dto.ModelTreeDTO;
import com.gatecm.obsession.entity.Member;
import com.gatecm.obsession.mapper.UcMember;
import com.gatecm.obsession.mapper.SysModelDao;
import com.gatecm.obsession.service.MemberService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商户信息表 服务实现类
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-10-17
 */
@Service
public class MemberServiceImpl extends ServiceImpl<UcMember, Member> implements MemberService {

	@Autowired
	private SysModelDao sysModelDao;

	@Autowired
	private UcMember memberDao;

	@Override
	public ModelTreeDTO getModelTreeBymemberId(Long memberId) {
		ModelTreeDTO rootTree = new ModelTreeDTO();
		rootTree.setId(0L);
		rootTree.setIsHasSon(true);
		List<ModelTreeDTO> modeltrees = sysModelDao.getModelTreesByMemberId(memberId);
		parseToTree(rootTree, modeltrees);
		return rootTree;
	}

	@Override
	public ModelTreeDTO getModelTreeByPhoneNumber(String phoneNumber) {
		Member member = memberDao.selectByPhoneNumber(phoneNumber);
		if (member != null) {
			return getModelTreeBymemberId(member.getId());
		}
		return null;
	}

	// 组合模型树（待优化）
	private void parseToTree(ModelTreeDTO rootTree, List<ModelTreeDTO> modeltrees) {
		if (rootTree.getIsHasSon()) {
			List<ModelTreeDTO> childModels = new ArrayList<>();
			Long rootId = rootTree.getId();
			ModelTreeDTO modelTreeDTO;
			Iterator<ModelTreeDTO> it = modeltrees.iterator();
			while (it.hasNext()) {
				modelTreeDTO = it.next();
				if (rootId.equals(modelTreeDTO.getParentModelId())) {
					childModels.add(modelTreeDTO);
				}
				if (!modelTreeDTO.getId().equals(rootId)) {
					parseToTree(modelTreeDTO, modeltrees);
				}
			}
			rootTree.setChildModels(childModels);
		}
	}
}
