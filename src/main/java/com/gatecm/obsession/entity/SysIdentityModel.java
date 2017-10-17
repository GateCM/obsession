package com.gatecm.obsession.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 商户身份模型映射表
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-10-17
 */
@TableName("sys_identity_model")
public class SysIdentityModel extends Model<SysIdentityModel> {

    private static final long serialVersionUID = 1L;

    /**
     * 商户身份ID
     */
    @TableId("identity_id")
	private Long identityId;
    /**
     * 模型ID
     */
	@TableField("model_id")
	private Long modelId;


	public Long getIdentityId() {
		return identityId;
	}

	public void setIdentityId(Long identityId) {
		this.identityId = identityId;
	}

	public Long getModelId() {
		return modelId;
	}

	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}

	@Override
	protected Serializable pkVal() {
		return this.identityId;
	}

	@Override
	public String toString() {
		return "SysIdentityModel{" +
			", identityId=" + identityId +
			", modelId=" + modelId +
			"}";
	}
}
