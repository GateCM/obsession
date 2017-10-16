package com.gatecm.obsession.service.impl;

import com.gatecm.obsession.entity.User;
import com.gatecm.obsession.mapper.UserDao;
import com.gatecm.obsession.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-10-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
	
}
