package com.ud.basic.system.controller.model.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class RoleRequest {

	@ApiModelProperty(value = "角色ID")
	private String roleId;
}
