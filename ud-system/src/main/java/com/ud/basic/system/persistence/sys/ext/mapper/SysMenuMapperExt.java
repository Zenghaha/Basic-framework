package com.ud.basic.system.persistence.sys.ext.mapper;

import java.util.List;
import java.util.Map;

import com.ud.basic.system.persistence.sys.auto.model.SysMenu;

public interface SysMenuMapperExt {

	List<SysMenu> listSubMenuByParentId(Integer menuId);

	int getMaxId();

	List<SysMenu> listAllServiceMenu(Map<String, Object> map);
}
