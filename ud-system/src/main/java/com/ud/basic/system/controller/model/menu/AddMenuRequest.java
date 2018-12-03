package com.ud.basic.system.controller.model.menu;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddMenuRequest {

	@ApiModelProperty(value = "父ID", required = true)
	@NotBlank(message = "参数[parentId]不能为空")
	private String parentId;
	
	@ApiModelProperty(value = "菜单名称", required = true)
	@NotBlank(message = "参数[menuName]不能为空")
	private String menuName;
	
	@ApiModelProperty(value = "菜单地址", required = true)
	@NotBlank(message = "参数[menuUrl]不能为空")
	private String menuUrl;
	
	@ApiModelProperty(value = "序号", required = true)
	@NotBlank(message = "参数[menuOrder]不能为空")
	private String menuOrder;
	
	@ApiModelProperty(value = "菜单类型", required = true)
	@NotBlank(message = "参数[menuType]不能为空")
	private String menuType;
	
	@ApiModelProperty(value = "菜单状态", required = true)
	@NotBlank(message = "参数[menuState]不能为空")
	private Integer menuState;
}
