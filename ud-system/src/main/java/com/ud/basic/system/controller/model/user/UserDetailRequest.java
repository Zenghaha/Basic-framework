package com.ud.basic.system.controller.model.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class UserDetailRequest {

	@ApiModelProperty(value = "用户ID")
	private String userId;
}
