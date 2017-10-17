package com.gatecm.obsession.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 商户身份角色表
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-10-17
 */
@TableName("sys_identity")
public class SysIdentity extends Model<SysIdentity> {

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
     * 角色身份名称
     */
	private String name;
    /**
     * 角色身份类型
     */
	private String type;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
		return "SysIdentity{" +
			", id=" + id +
			", gmtModify=" + gmtModify +
			", gmtCreate=" + gmtCreate +
			", name=" + name +
			", type=" + type +
			", isDel=" + isDel +
			"}";
	}
}
