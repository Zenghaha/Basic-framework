package com.ud.basic.system.controller.model.menu;

import java.util.Date;

import lombok.Data;

@Data
public class SysMenuVO {

	private Integer menuId;

    private String menuName;

    private String menuUrl;

    private String parentId;

    private String menuOrder;

    private String menuIcon;

    private String menuType;

    private String menuState;

    private Date createdDate;

    private String createdBy;

    private Date lastModifiedDate;

    private String lastModifiedBy;

    private Boolean delFlag;
    
    private String parentName;
}
