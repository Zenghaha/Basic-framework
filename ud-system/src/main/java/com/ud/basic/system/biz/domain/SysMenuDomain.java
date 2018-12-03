package com.ud.basic.system.biz.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ud.basic.system.persistence.sys.auto.mapper.SysMenuMapper;
import com.ud.basic.system.persistence.sys.auto.model.SysMenu;
import com.ud.basic.system.persistence.sys.ext.mapper.SysMenuMapperExt;
import com.ud.basic.system.persistence.sys.ext.model.Menu;

@Service
public class SysMenuDomain {

	@Autowired
	SysMenuMapper sysMenuMapper;
	
	@Autowired
	SysMenuMapperExt sysMenuExtMapper;

	public List<SysMenu> listSubMenuByParentId(Integer menuId) {
		return sysMenuExtMapper.listSubMenuByParentId(menuId);
	}

	public SysMenu getMenuById(Integer menuId) {
		return sysMenuMapper.selectByPrimaryKey(menuId);
	}

	public int getMaxId() {
		return sysMenuExtMapper.getMaxId();
	}

	public void saveMenu(SysMenu menu) {
		sysMenuMapper.insertSelective(menu);
	}

	public void deleteMenuById(Integer menuId) {
		sysMenuMapper.deleteByPrimaryKey(menuId);
	}

	public void edit(SysMenu menu) {
		sysMenuMapper.updateByPrimaryKeySelective(menu);
	}

	public List<Menu> listAllMenu(Integer menuId) {
		List<Menu> menuList = new ArrayList<>();
		List<SysMenu> list = this.listSubMenuByParentId(menuId);
		for (SysMenu sysMenu : list) {
			Menu menu = new Menu();
			BeanUtils.copyProperties(sysMenu, menu);
			menu.setMenuState(sysMenu.getMenuState().toString());
			menu.setSubMenu(this.listAllMenu(menu.getMenuId()));
			menu.setTarget("treeFrame");
			menu.setIsParent(sysMenu.getIsParent());
			menuList.add(menu);
		}
		return menuList;
	}

	public List<Menu> listAllServiceMenu(Map<String,Object> map) {
		List<Menu> menuList = new ArrayList<>();
		List<SysMenu> list = sysMenuExtMapper.listAllServiceMenu(map);
		for (SysMenu sysMenu : list) {
			Menu menu = new Menu();
			BeanUtils.copyProperties(sysMenu, menu);
			Map<String,Object> childMap = new HashMap<>();
			childMap.put("menuId", sysMenu.getMenuId());
			childMap.put("menuType", "2");
			menu.setSubMenu(this.listAllServiceMenu(childMap));
			menu.setTarget("treeFrame");
			menu.setMenuState(sysMenu.getMenuState().toString());
			menu.setIsParent(sysMenu.getIsParent());
			menuList.add(menu);
		}
		return menuList;
	}
}
