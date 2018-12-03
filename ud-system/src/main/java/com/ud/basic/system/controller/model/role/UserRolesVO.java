package com.ud.basic.system.controller.model.role;

import java.util.List;

import lombok.Data;

@Data
public class UserRolesVO {

	private String roleId;
	
	private String roleName;
	
	private List<SysRoleVO> ChildRoleList;
}
