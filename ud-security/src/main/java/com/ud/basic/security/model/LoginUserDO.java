package com.ud.basic.security.model;

import java.util.Date;

import lombok.Data;

@Data
public class LoginUserDO {

	private Long userId;
	
	private Long orgId;
	
	private String type;

    private String username;

    private String password;

    private String name;

    private String rights;

    private Long roleId;

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
