package com.gatecm.obsession.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 商户身份映射表
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-10-17
 */
@TableName("uc_member_identity")
public class MemberIdentity extends Model<MemberIdentity> {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	@TableField("member_id")
	private Long memberId;
	/**
	 * 商户身份ID
	 */
	@TableField("identity_id")
	private Long identityId;

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Long getIdentityId() {
		return identityId;
	}

	public void setIdentityId(Long identityId) {
		this.identityId = identityId;
	}

	@Override
	protected Serializable pkVal() {
		return this.memberId.toString() + this.identityId.toString();
	}

	@Override
	public String toString() {
		return "MemberIdentity{" + ", memberId=" + memberId + ", identityId=" + identityId + "}";
	}
}
