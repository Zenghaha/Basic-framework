package com.ud.basic.system.biz.service;

import java.util.List;

import com.ud.basic.system.biz.model.DO.SysMenuDO;
import com.ud.basic.system.controller.model.menu.AddMenuRequest;
import com.ud.basic.system.controller.model.menu.SysMenuVO;
import com.ud.basic.system.persistence.sys.ext.model.Menu;

public interface MenuService {

	List<SysMenuVO> list(SysMenuDO menuDO);

	Void add(AddMenuRequest request);

	Void delete(SysMenuDO menuDO);

	SysMenuVO detail(SysMenuDO menuDO);

	Void edit(SysMenuDO menuDO);

	List<Menu> listAllMenu();

	List<Menu> indexMenuList();

	List<Menu> listAllServiceMenu();

}
