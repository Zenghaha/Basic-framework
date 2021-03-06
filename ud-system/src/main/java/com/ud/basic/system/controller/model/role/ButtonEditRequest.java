package com.ud.basic.system.controller.model.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class ButtonEditRequest {

	@ApiModelProperty(value = "角色ID")
	private String roleId;
	
	@ApiModelProperty(value = "按钮类型")
	private String buttonType;
	
	@ApiModelProperty(value = "菜单ID")
	private String menuIds;
}
