package com.gatecm.obsession.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 商户身份权限映射表
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-10-17
 */
@TableName("sys_identity_permission")
public class SysIdentityPermission extends Model<SysIdentityPermission> {

	private static final long serialVersionUID = 1L;

	/**
	 * 商户身份ID
	 */
	@TableField("identity_id")
	private Long identityId;
	/**
	 * 权限ID
	 */
	@TableField("permission_id")
	private Long permissionId;

	public Long getIdentityId() {
		return identityId;
	}

	public void setIdentityId(Long identityId) {
		this.identityId = identityId;
	}

	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	@Override
	protected Serializable pkVal() {
		return this.identityId.toString() + this.permissionId.toString();
	}

	@Override
	public String toString() {
		return "SysIdentityPermission{" + ", identityId=" + identityId + ", permissionId=" + permissionId + "}";
	}
}
