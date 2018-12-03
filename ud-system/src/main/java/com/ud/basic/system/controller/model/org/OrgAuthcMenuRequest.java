package com.ud.basic.system.controller.model.org;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrgAuthcMenuRequest {

	@ApiModelProperty(value = "组织ID")
	private String orgId;
}
