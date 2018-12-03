package com.ud.basic.system.biz.model.DO;

import java.util.Date;

import lombok.Data;

@Data
public class SysRoleDO {

	private Long roleId;
	private String orgId;
    private String roleName;
    private String rights;
    private Long parentId;
    
    private Boolean isDefault;
    private Date createdDate;

    private String createdBy;

    private Date lastModifiedDate;

    private String lastModifiedBy;

    private Boolean delFlag;

    private String companyName;

    private String department;

    private String position;
}
