package com.gatecm.obsession.service.impl;

import com.gatecm.obsession.entity.Member;
import com.gatecm.obsession.mapper.MemberDao;
import com.gatecm.obsession.service.MemberService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
public class MemberServiceImpl extends ServiceImpl<MemberDao, Member> implements MemberService {
	
}
