package com.ud.basic.system.biz.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.ud.basic.system.biz.domain.SysFhlogDomain;
import com.ud.basic.system.biz.domain.SysMenuDomain;
import com.ud.basic.system.biz.domain.SysOrgDomain;
import com.ud.basic.system.biz.domain.SysResourceDomain;
import com.ud.basic.system.biz.domain.SysRoleDomain;
import com.ud.basic.system.biz.domain.SysUserDomain;
import com.ud.basic.system.biz.model.DO.SysRoleDO;
import com.ud.basic.system.biz.service.MenuService;
import com.ud.basic.system.biz.service.RoleService;
import com.ud.basic.system.controller.model.role.AuthcEditRequest;
import com.ud.basic.system.controller.model.role.AuthcMenuVO;
import com.ud.basic.system.controller.model.role.RoleArrayRequest;
import com.ud.basic.system.controller.model.role.RoleListRequest;
import com.ud.basic.system.controller.model.role.RoleRequest;
import com.ud.basic.system.controller.model.role.SysRoleVO;
import com.ud.basic.system.controller.model.role.UserRolesVO;
import com.ud.basic.system.persistence.sys.auto.model.SysMenu;
import com.ud.basic.system.persistence.sys.auto.model.SysResource;
import com.ud.basic.system.persistence.sys.auto.model.SysRole;
import com.ud.basic.system.persistence.sys.ext.model.Menu;
import com.ud.basic.system.util.RightsHelper;
import com.ud.basic.common.core.exception.CommonBizException;
import com.ud.basic.common.enums.ResultCode;
import com.ud.basic.common.util.DateUtil;
import com.ud.basic.common.util.LoginUtil;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	SysRoleDomain sysRoleDomain;

	@Autowired
	SysFhlogDomain sysFhlogDomain;

	@Autowired
	SysUserDomain sysUserDomain;

	@Autowired
	MenuService menuService;

	@Autowired
	SysMenuDomain sysMenuDomain;

	@Autowired
	SysOrgDomain sysOrgDomain;
	
	@Autowired
	SysResourceDomain sysResourceDomain;

	@Override
	public List<UserRolesVO> listAllRoles() {
		List<UserRolesVO> list = new ArrayList<>();
		String orgId =LoginUtil.getLoginOwner();
		List<SysRoleVO> roleGroup = sysRoleDomain.listAllRoleArrByOrgId(orgId);
		for (SysRoleVO sysRoleVO : roleGroup) {
			UserRolesVO vo = new UserRolesVO();
			vo.setRoleId(sysRoleVO.getRoleId());
			vo.setRoleName(sysRoleVO.getRoleName());
			vo.setChildRoleList(sysRoleDomain.listAllRolesByPId(sysRoleVO.getRoleId()));
			list.add(vo);
		}
		return list;
	}

	@Override
	public List<SysRoleVO> groupList(RoleArrayRequest request) {
		String orgId = StringUtils.isEmpty(request.getOrgId())?
				LoginUtil.getLoginOwner() : request.getOrgId();
		return sysRoleDomain.listAllRoleArrByOrgId(orgId);
	}

	@Override
	public List<SysRoleVO> list(RoleListRequest request) {
		String orgId = StringUtils.isEmpty(request.getOrgId())?
				LoginUtil.getLoginOwner() : request.getOrgId();
		String roleId = request.getRoleId();
		Map<String, String> map = new HashMap<>();
		map.put("orgId", orgId);
		map.put("roleId", roleId);
		return sysRoleDomain.listAllRolesByOrgId(map);
	}

	@Override
	public Void add(SysRoleDO roleDO) {
		SysRole role = new SysRole();
		BeanUtils.copyProperties(roleDO, role);
		/*
		 * if (role.getParentId().equals("0")) { role.setRights(""); } else { String
		 * rights = sysRoleDomain.findById(role.getParentId()).getRights();
		 * role.setRights(StringUtils.isEmpty(rights) ? "" : rights); }
		 */
		String orgId = StringUtils.isEmpty(roleDO.getOrgId())?
				LoginUtil.getLoginOwner() : roleDO.getOrgId();
		role.setOrgId(Long.valueOf(orgId));
		role.setRights("");
		role.setCreatedDate(DateUtil.getCurrentDate());
		sysRoleDomain.addRole(role);
		sysFhlogDomain.save(LoginUtil.getLoginName(), "新增角色" + role.getRoleId());
		return null;
	}

	@Override
	public SysRoleVO detail(RoleRequest request) {
		SysRoleVO vo = new SysRoleVO();
		SysRole role = sysRoleDomain.findById(Long.valueOf(request.getRoleId()));
		if (role != null) {
			BeanUtils.copyProperties(role, vo);
		}
		return null;
	}

	@Override
	public Void edit(SysRoleDO roleDO) {
		SysRole role = new SysRole();
		BeanUtils.copyProperties(roleDO, role);
		sysRoleDomain.editRole(role);
		sysFhlogDomain.save(LoginUtil.getLoginName(), "编辑角色" + role.getRoleId());
		return null;
	}

	@Override
	public Void delete(RoleRequest request) {
		String roleId = request.getRoleId();
		List<SysRoleVO> roleList = sysRoleDomain.listAllRolesByPId(roleId);
		if (roleList.size() > 0) {
			throw new CommonBizException(ResultCode.EXIST_CHILD.getModel());
		}
		if (sysUserDomain.listAllUserByRoldId(roleId) > 0) {
			throw new CommonBizException(ResultCode.ROLE_INUSE.getModel());
		}
		sysRoleDomain.deleteRole(Long.valueOf(roleId));
		sysFhlogDomain.save(LoginUtil.getLoginName(), "删除角色" + roleId);
		return null;
	}

	@Override
	public AuthcMenuVO authcMenu(RoleRequest request) {
		AuthcMenuVO vo = new AuthcMenuVO();
		SysRole role = sysRoleDomain.findById(Long.valueOf(request.getRoleId()));
		String rights = role.getRights();
		List<Menu> menuList = menuService.listAllMenu();
		List<String> idList = new ArrayList<>();
		String parentRights = null;
		if (role.getParentId() == 0) {
			parentRights = sysOrgDomain.get(Long.valueOf(LoginUtil.getLoginOwner())).getRights();

		} else {
			parentRights = sysRoleDomain.findById(Long.valueOf(role.getParentId())).getRights();
		}
		menuList = this.readMenu(menuList, parentRights);
		this.readMenu(menuList, rights, idList);
		vo.setMenuList(menuList);
		vo.setIdList(idList);
		return vo;
	}

	@Override
	public Void authcEdit(AuthcEditRequest request) {
		SysRole role = sysRoleDomain.findById(Long.valueOf(request.getRoleId()));
		String menuIds = request.getMenuIds();
		if (StringUtils.isEmpty(menuIds)) {
			role.setRights("");
			role.setResourceRights("");
			sysRoleDomain.editRole(role);
		} else {
			Set<Integer> set = new HashSet<>();
			List<String> menuIdList = Arrays.asList(menuIds.split(","));
			String resourceRights = role.getResourceRights();
			for (String menuId : menuIdList) {
				set.add(Integer.parseInt(menuId));
				SysMenu menu = sysMenuDomain.getMenuById(Integer.parseInt(menuId));
				set.addAll(JSON.parseArray(menu.getMenuParentJson(), Integer.class));
				List<SysResource> resourcesList = sysResourceDomain.getResources(Long.valueOf(menuId));
				List<String> resIdList = new ArrayList<>();
				for (SysResource sysResource : resourcesList) {
					resIdList.add(sysResource.getId().toString());
				}
				resourceRights = RightsHelper.sumRights(resourceRights,resIdList);
			}
			BigInteger menuRight = RightsHelper.sumRights(set);
			role.setRights(menuRight.toString());
			role.setResourceRights(resourceRights);
			sysRoleDomain.editRole(role);
		}
		/*
		 * if (!role.getRoleId().equals("1")) { Map<String, Object> map = new HashMap();
		 * map.put("roleId", role.getRoleId()); map.put("rights", rights);
		 * sysRoleDomain.setAllRights(map); }
		 */
		sysFhlogDomain.save(LoginUtil.getLoginName(), "修改角色菜单权限，角色ID为:" + role.getRoleId());
		return null;
	}

	public List<Menu> readMenu(List<Menu> menuList, String roleRights, List<String> idList) {
		for (int i = 0; i < menuList.size(); i++) {
			menuList.get(i).setHasMenu(RightsHelper.testRights(roleRights, menuList.get(i).getMenuId()));
			if (menuList.get(i).isHasMenu() && !menuList.get(i).getIsParent()) {
				idList.add(menuList.get(i).getMenuId().toString());
			}
			this.readMenu(menuList.get(i).getSubMenu(), roleRights, idList); // 是：继续排查其子菜单
		}
		return menuList;
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
