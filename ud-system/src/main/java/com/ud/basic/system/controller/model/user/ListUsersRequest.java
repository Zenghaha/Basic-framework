package com.ud.basic.system.controller.model.user;

import com.ud.basic.common.model.PageRequest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class ListUsersRequest extends PageRequest{

	@ApiModelProperty(value = "关键词")
	private String keywords;
	
	@ApiModelProperty(value = "开始日期")
	private String lastLoginStart;
	
	@ApiModelProperty(value = "结束日期")
	private String lastLoginEnd;
	
	@ApiModelProperty(value = "角色ID")
	private String roleId;
	
}
