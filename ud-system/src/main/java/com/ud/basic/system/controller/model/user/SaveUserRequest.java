package com.ud.basic.system.controller.model.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class SaveUserRequest {

	@ApiModelProperty(value = "角色ID")
	private Long roleId;
	
	@ApiModelProperty(value = "用户名")
	private String username;
	
	@ApiModelProperty(value = "编号")
	private String number;
	
	@ApiModelProperty(value = "密码")
	private String password;
	
	@ApiModelProperty(value = "姓名")
	private String name;
	
	@ApiModelProperty(value = "手机号")
	private String phone;
	
	@ApiModelProperty(value = "邮箱")
	private String email;
	
	@ApiModelProperty(value = "备注")
	private String bz;
	
}
