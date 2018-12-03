package com.ud.basic.system.biz.model.DO;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class SysMenuDO {

	private Integer menuId;
	@ApiModelProperty(value = "菜单名")
    private String menuName;
	@ApiModelProperty(value = "菜单地址")
    private String menuUrl;
	@ApiModelProperty(value = "父级ID")
    private String parentId;
	@ApiModelProperty(value = "序号")
    private String menuOrder;
	@ApiModelProperty(value = "菜单图标")
    private String menuIcon;
	@ApiModelProperty(value = "菜单类型")
    private String menuType;
	@ApiModelProperty(value = "菜单状态")
    private Integer menuState;

    private Date createdDate;

    private String createdBy;

    private Date lastModifiedDate;

    private String lastModifiedBy;

    private Boolean delFlag;
}
