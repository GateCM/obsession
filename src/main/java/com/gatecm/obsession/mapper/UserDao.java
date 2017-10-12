package com.gatecm.obsession.mapper;

import com.gatecm.obsession.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-10-11
 */
public interface UserDao extends BaseMapper<User> {

	/**
	 * 
	 */
	Integer test();

}