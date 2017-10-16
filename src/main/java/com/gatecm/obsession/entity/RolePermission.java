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
@TableName("u_role_permission")
public class RolePermission extends Model<RolePermission> {

	private static final long serialVersionUID = 1L;

	/**
	 * 角色ID
	 */
	private Long rid;
	/**
	 * 权限ID
	 */
	private Long pid;

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	@Override
	protected Serializable pkVal() {
		return this.rid.toString() + this.pid.toString();
	}

	@Override
	public String toString() {
		return "RolePermission{" + ", rid=" + rid + ", pid=" + pid + "}";
	}
}
