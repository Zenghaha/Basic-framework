package com.ud.basic.system.controller.model.user;

import lombok.Data;

@Data
public class ListUserVO {

	private String userId;
	
	private String username;

	private String password;

	private String lastLogin;

	private String name;

	private String ip;

	private String email;

	private String number;

	private String phone;

	private String roleId;

	private String roleName;
}
