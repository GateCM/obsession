/**
 * 
 */
package com.gatecm.obsession.dto;

import java.util.List;

import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import com.gatecm.obsession.entity.SysModel;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年10月18日 上午9:37:10
 *
 */
public class ModelTreeDTO extends SysModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5390216444742786267L;

	private List<ModelTreeDTO> childModels;

	public List<ModelTreeDTO> getChildModels() {
		return childModels;
	}

	public void setChildModels(List<ModelTreeDTO> childModels) {
		this.childModels = childModels;
	}

	public void print(String tab) {
		System.err.println(tab + toString());
		if (!CollectionUtils.isEmpty(childModels)) {
			for (int i = 0, len = childModels.size(); i < len; i++) {
				childModels.get(i).print(tab + tab);
			}
		}
	}

	@Override
	public String toString() {
		return "ModelTreeDTO [childModels=" + childModels + "]";
	}

}
