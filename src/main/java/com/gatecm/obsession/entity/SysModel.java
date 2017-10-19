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
 * 系统模型表
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-10-17
 */
@TableName("sys_model")
public class SysModel extends Model<SysModel> {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId(value = "id", type = IdType.AUTO)
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
	 * 模型名称
	 */
	private String name;
	/**
	 * 模型类型
	 */
	private String type;
	/**
	 * 模型样式
	 */
	private String style;
	/**
	 * 排序，升序排列
	 */
	private Integer sortOrder;
	/**
	 * 模型显示名称
	 */
	@TableField("show_name")
	private String showName;
	/**
	 * 是否有子节点
	 */
	@TableField("is_has_son")
	private Boolean isHasSon;
	/**
	 * 父节点id
	 */
	@TableField("parent_model_id")
	private Long parentModelId;
	/**
	 * 模型对应跳转url
	 */
	@TableField("link_url")
	private String linkUrl;
	/**
	 * 是否开启新页面
	 */
	@TableField("is_new_blank")
	private Boolean isNewBlank;
	/**
	 * 是否已删除
	 */
	@TableField("is_del")
	private Boolean isDel;

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

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public Boolean getIsHasSon() {
		return isHasSon;
	}

	public void setIsHasSon(Boolean isHasSon) {
		this.isHasSon = isHasSon;
	}

	public Long getParentModelId() {
		return parentModelId;
	}

	public void setParentModelId(Long parentModelId) {
		this.parentModelId = parentModelId;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public Boolean getIsNewBlank() {
		return isNewBlank;
	}

	public void setIsNewBlank(Boolean isNewBlank) {
		this.isNewBlank = isNewBlank;
	}

	public Boolean getIsDel() {
		return isDel;
	}

	public void setIsDel(Boolean isDel) {
		this.isDel = isDel;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "SysModel{" + ", id=" + id + ", gmtModify=" + gmtModify + ", gmtCreate=" + gmtCreate + ", name=" + name
				+ ", type=" + type + ", style=" + style + ", sortOrder=" + sortOrder + ", showName=" + showName + ", isHasSon="
				+ isHasSon + ", parentModelId=" + parentModelId + ", linkUrl=" + linkUrl + ", isNewBlank=" + isNewBlank
				+ ", isDel=" + isDel + "}";
	}
}
