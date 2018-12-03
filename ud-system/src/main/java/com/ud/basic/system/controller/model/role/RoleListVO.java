package com.ud.basic.system.controller.model.role;

import java.util.List;

import lombok.Data;

@Data
public class RoleListVO {

	private List<SysRoleVO> roleArray;
	
	private List<SysRoleVO> roleList;
}
