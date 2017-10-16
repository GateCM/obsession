package com.gatecm.obsession.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-10-16
 */
@TableName("u_user_role")
public class UserRole extends Model<UserRole> {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	private Long uid;
	/**
	 * 角色ID
	 */
	private Long rid;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	@Override
	protected Serializable pkVal() {
		return this.rid.toString() + this.uid.toString();
	}

	@Override
	public String toString() {
		return "UserRole{" + ", uid=" + uid + ", rid=" + rid + "}";
	}
}
