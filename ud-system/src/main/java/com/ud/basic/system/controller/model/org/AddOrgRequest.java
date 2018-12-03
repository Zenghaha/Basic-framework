package com.ud.basic.system.controller.model.org;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddOrgRequest {
	
	@ApiModelProperty(value = "组织名称")
	private String orgName;
	
	@ApiModelProperty(value = "组织英文名")
	private String orgNameEn;
	
}
