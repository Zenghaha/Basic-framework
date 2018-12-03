package com.ud.basic.system.controller.model.user;

import java.util.Date;

import lombok.Data;

@Data
public class SysUserVO {

	private String userId;

    private String username;

    private String name;

    private String rights;

    private String roleId;
    
    private String parentRoleId;
    
    private String orgId;

    private String lastLogin;

    private String ip;

    private String status;

    private String bz;

    private String skin;

    private String email;

    private String number;

    private String phone;

    private Date createdDate;

    private String createdBy;

    private Date lastModifiedDate;

    private String lastModifiedBy;

    private Boolean delFlag;

    private String head;
    
    private String companyName;
    
    private String department;
    
    private String position;
}
