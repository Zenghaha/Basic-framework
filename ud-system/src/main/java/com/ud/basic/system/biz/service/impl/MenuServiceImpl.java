package com.ud.basic.system.biz.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ud.basic.system.biz.domain.SysFhlogDomain;
import com.ud.basic.system.biz.domain.SysMenuDomain;
import com.ud.basic.system.biz.domain.SysRoleDomain;
import com.ud.basic.system.biz.domain.SysUserDomain;
import com.ud.basic.system.biz.model.DO.SysMenuDO;
import com.ud.basic.system.biz.model.DO.SysUserDO;
import com.ud.basic.system.biz.service.MenuService;
import com.ud.basic.system.controller.model.menu.AddMenuRequest;
import com.ud.basic.system.controller.model.menu.SysMenuVO;
import com.ud.basic.system.persistence.sys.auto.model.SysMenu;
import com.ud.basic.system.persistence.sys.ext.model.Menu;
import com.ud.basic.system.util.RightsHelper;
import com.ud.basic.common.core.exception.CommonBizException;
import com.ud.basic.common.enums.ResultCode;
import com.ud.basic.common.util.LoginUtil;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	SysMenuDomain sysMenuDomain;

	@Autowired
	SysFhlogDomain sysFhlogDomain;

	@Autowired
	SysRoleDomain sysRoleDomain;

	@Autowired
	SysUserDomain sysUserDomain;

	@Override
	public List<SysMenuVO> list(SysMenuDO menuDO) {
		List<SysMenuVO> voList = new ArrayList<>();
		Integer menuId = StringUtils.isEmpty(menuDO.getMenuId()) ? 0 : menuDO.getMenuId();
		List<SysMenu> list = sysMenuDomain.listSubMenuByParentId(menuId);
		for (SysMenu sysMenu : list) {
			SysMenuVO vo = new SysMenuVO();
			BeanUtils.copyProperties(sysMenu, vo);
			if (!sysMenu.getParentId().equals("0")) {
				vo.setParentName(sysMenuDomain.getMenuById(Integer.parseInt(sysMenu.getParentId())).getMenuName());
			} else {
				vo.setParentName("顶级菜单");
			}
			vo.setMenuState(sysMenu.getMenuState().toString());
			voList.add(vo);
		}
		return voList;
	}

	@Override
	public Void add(AddMenuRequest request) {
		SysMenu menu = new SysMenu();
		BeanUtils.copyProperties(request, menu);
		// menu.setMenuId(sysMenuDomain.getMaxId() + 1);
		menu.setMenuIcon("menu-icon fa fa-leaf black"); // 默认菜单图标
		menu.setIsParent(false);
		if (request.getParentId().equals("0")) {
			menu.setMenuParentJson("[0]");
		} else {
			SysMenu parentMenu = sysMenuDomain.getMenuById(Integer.parseInt(request.getParentId()));
			String menuParentJson = parentMenu.getMenuParentJson();
			JSONArray parseArray = JSON.parseArray(menuParentJson);
			parseArray.add(parentMenu.getMenuId());
			menu.setMenuParentJson(parseArray.toJSONString());
			
		}
		sysMenuDomain.saveMenu(menu);
		SysMenu editParentMenu = new SysMenu();
		editParentMenu.setMenuId(Integer.parseInt(request.getParentId()));
		editParentMenu.setIsParent(true);
		sysMenuDomain.edit(editParentMenu);
		sysFhlogDomain.save(LoginUtil.getLoginName(), "新增菜单" + menu.getMenuId());
		return null;
	}

	@Override
	public Void delete(SysMenuDO menuDO) {
		Integer menuId = menuDO.getMenuId();
		if (sysMenuDomain.listSubMenuByParentId(menuId).size() > 0) {
			throw new CommonBizException(ResultCode.EXIST_CHILD.getModel());
		}
		sysMenuDomain.deleteMenuById(menuId);
		return null;
	}

	@Override
	public SysMenuVO detail(SysMenuDO menuDO) {
		SysMenuVO vo = new SysMenuVO();
		SysMenu menu = sysMenuDomain.getMenuById(menuDO.getMenuId());
		BeanUtils.copyProperties(menu, vo);
		vo.setMenuState(menu.getMenuState().toString());
		if (!menu.getParentId().equals("0")) {
			vo.setParentName(sysMenuDomain.getMenuById(Integer.parseInt(menu.getParentId())).getMenuName());
		} else {
			vo.setParentName("顶级菜单");
		}
		return vo;
	}

	@Override
	public Void edit(SysMenuDO menuDO) {
		SysMenu menu = new SysMenu();
		BeanUtils.copyProperties(menuDO, menu);
		sysMenuDomain.edit(menu);
		return null;
	}

	@Override
	public List<Menu> listAllMenu() {
		return sysMenuDomain.listAllMenu(0);
	}
	
	@Override
	public List<Menu> listAllServiceMenu() {
		Map<String,Object> map = new HashMap<>();
		map.put("menuId", 0);
		map.put("menuType", "2");
		return sysMenuDomain.listAllServiceMenu(map);
	}

	@Override
	public List<Menu> indexMenuList() {
		SysUserDO user = sysUserDomain.getByUserName(LoginUtil.getLoginName());
		Long roleId = user.getRoleId();
		String rights = sysRoleDomain.findById(roleId).getRights();
		List<Menu> list = this.listAllMenu();
		list = this.readMenu(list, rights);
		return list;
	}

	public List<Menu> readMenu(List<Menu> menuList, String roleRights) {
		for (int i = 0; i < menuList.size(); i++) {
			menuList.get(i).setHasMenu(RightsHelper.testRights(roleRights, menuList.get(i).getMenuId()));
			if (menuList.get(i).isHasMenu() && "1".equals(menuList.get(i).getMenuState())) { // 判断是否有此菜单权限并且是否隐藏
				this.readMenu(menuList.get(i).getSubMenu(), roleRights); // 是：继续排查其子菜单
			} else {
				menuList.remove(i);
				i--;
			}
		}
		return menuList;
	}
}
