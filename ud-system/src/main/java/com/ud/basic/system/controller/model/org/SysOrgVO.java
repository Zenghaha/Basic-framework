package com.ud.basic.system.controller.model.org;

import java.util.Date;

import lombok.Data;

@Data
public class SysOrgVO {

	private Long id;

    private String nameEn;

    private String name;

    private String rights;

    private String type;

    private Date createTime;

    private Date updateTime;
}
