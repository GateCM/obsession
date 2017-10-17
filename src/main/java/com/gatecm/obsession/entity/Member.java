package com.gatecm.obsession.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 商户信息表
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-10-17
 */
@TableName("uc_member")
public class Member extends Model<Member> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 修改时间
     */
	@TableField("gmt_modify")
	private Date gmtModify;
    /**
     * 创建时间
     */
	@TableField("gmt_create")
	private Date gmtCreate;
    /**
     * 用户昵称
     */
	private String nickname;
    /**
     * 邮箱|登录帐号
     */
	@TableField("phone_number")
	private String phoneNumber;
    /**
     * 密码
     */
	private String pswd;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 最后登录时间
     */
	@TableField("last_login_time")
	private Date lastLoginTime;
    /**
     * 1:有效，0:禁止登录
     */
	private Long status;
	private String salt;
    /**
     * 是否已删除
     */
	@TableField("is_del")
	private Integer isDel;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getGmtModify() {
		return gmtModify;
	}

	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Member{" +
			", id=" + id +
			", gmtModify=" + gmtModify +
			", gmtCreate=" + gmtCreate +
			", nickname=" + nickname +
			", phoneNumber=" + phoneNumber +
			", pswd=" + pswd +
			", createTime=" + createTime +
			", lastLoginTime=" + lastLoginTime +
			", status=" + status +
			", salt=" + salt +
			", isDel=" + isDel +
			"}";
	}
}
