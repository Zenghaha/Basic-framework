package com.ud.basic.system.controller.model.role;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RoleArrayRequest {

	@ApiModelProperty(value = "组织ID")
	private String orgId;
}
