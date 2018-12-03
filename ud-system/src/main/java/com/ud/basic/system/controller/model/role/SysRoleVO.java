package com.ud.basic.system.controller.model.role;

import java.util.Date;

import lombok.Data;

@Data
public class SysRoleVO {

	private String roleId;

	private String roleName;

	private String rights;
	
	private String orgId;

	private String parentId;
	
	private boolean isDefault;

	private Date createdDate;

	private String createdBy;

	private Date lastModifiedDate;

	private String lastModifiedBy;

	private Boolean delFlag;

	private String companyName;

	private String department;

	private String position;
}
