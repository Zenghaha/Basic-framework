package com.ud.basic.system.controller.model.org;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrgAuthcEditRequest {

	@ApiModelProperty(value = "组织ID")
	private String orgId;
	
	@ApiModelProperty(value = "菜单ID")
	private String menuIds;
}
