package com.ud.basic.system.controller.model.role;

import java.util.List;

import com.ud.basic.system.persistence.sys.ext.model.Menu;

import lombok.Data;

@Data
public class AuthcMenuVO {

	private List<Menu> menuList;
	
	private List<String> idList;
}
