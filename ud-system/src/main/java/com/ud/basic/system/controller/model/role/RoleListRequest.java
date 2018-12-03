package com.ud.basic.system.controller.model.role;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RoleListRequest {

	@ApiModelProperty(value = "角色组ID")
	private String roleId;
	
	@ApiModelProperty(value = "组织ID")
	private String orgId;
}

