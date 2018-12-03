package com.ud.basic.system.persistence.sys.ext.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Menu implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2776681653418989267L;
	
	private Integer menuId;		//菜单ID
	private String menuName;	//菜单名称
	private String menuUrl;	//链接
	private String parentId;	//上级菜单ID
	private String menuOrder;	//排序
	private String menuIcon;	//图标
	private String menuType;	//类型
	private String menuState;	//菜单状态
	private String target;
	private Menu parentMenu;
	private List<Menu> subMenu;
	private boolean hasMenu = false;
	private Boolean isParent;
	
}
