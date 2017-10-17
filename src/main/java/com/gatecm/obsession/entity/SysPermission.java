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
 * 系统权限表
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-10-17
 */
@TableName("sys_permission")
public class SysPermission extends Model<SysPermission> {

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
     * url地址
     */
	private String url;
    /**
     * url描述
     */
	private String name;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "SysPermission{" +
			", id=" + id +
			", gmtModify=" + gmtModify +
			", gmtCreate=" + gmtCreate +
			", url=" + url +
			", name=" + name +
			", isDel=" + isDel +
			"}";
	}
}
