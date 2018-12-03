package com.ud.basic.system.biz.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.ud.basic.common.core.exception.CommonBizException;
import com.ud.basic.common.enums.ResultCode;
import com.ud.basic.common.model.PageData;
import com.ud.basic.common.model.PageParameter;
import com.ud.basic.system.biz.domain.SysMenuDomain;
import com.ud.basic.system.biz.domain.SysOrgDomain;
import com.ud.basic.system.biz.domain.SysRoleDomain;
import com.ud.basic.system.biz.domain.SysUserDomain;
import com.ud.basic.system.biz.enums.UserTypeEnum;
import com.ud.basic.system.biz.service.MenuService;
import com.ud.basic.system.biz.service.OrgService;
import com.ud.basic.system.controller.model.org.AddOrgRequest;
import com.ud.basic.system.controller.model.org.EditOrgRequest;
import com.ud.basic.system.controller.model.org.ListOrgRequest;
import com.ud.basic.system.controller.model.org.OrgAuthcEditRequest;
import com.ud.basic.system.controller.model.org.OrgAuthcMenuRequest;
import com.ud.basic.system.controller.model.org.SysOrgVO;
import com.ud.basic.system.controller.model.role.AuthcMenuVO;
import com.ud.basic.system.persistence.sys.auto.model.SysMenu;
import com.ud.basic.system.persistence.sys.auto.model.SysOrg;
import com.ud.basic.system.persistence.sys.auto.model.SysRole;
import com.ud.basic.system.persistence.sys.auto.model.SysUser;
import com.ud.basic.system.persistence.sys.ext.model.Menu;
import com.ud.basic.system.util.RightsHelper;
import com.ud.basic.common.util.DateUtil;

@Service
public class OrgServiceImpl implements OrgService {

	@Autowired
	SysOrgDomain sysOrgDomain;

	@Autowired
	SysRoleDomain sysRoleDomain;

	@Autowired
	SysUserDomain sysUserDomain;

	@Autowired
	SysMenuDomain sysMenuDomain;

	@Autowired
	MenuService menuService;

	@Override
	public PageData<SysOrgVO> ListOrgs(ListOrgRequest request) {
		PageData<SysOrgVO> pd = new PageData<>();
		List<SysOrgVO> orgList = new ArrayList<>();
		SysOrg model = new SysOrg();
		BeanUtils.copyProperties(request, model);
		Page<SysOrg> listPage = sysOrgDomain.listPage(model,
				new PageParameter(request.getCurrentPage(), request.getShowCount()));
		for (SysOrg sysOrg : listPage) {
			SysOrgVO vo = new SysOrgVO();
			BeanUtils.copyProperties(sysOrg, vo);
			orgList.add(vo);
		}
		pd.setTotal((int) listPage.getTotal());
		pd.setRows(orgList);
		return pd;
	}

	@Override
	public String addOrg(AddOrgRequest request) {
		Pattern p = Pattern.compile("^[A-Za-z]+$");
		if (!p.matcher(request.getOrgNameEn()).matches()) {
			throw new CommonBizException(ResultCode.ORG_ENGLISHNAME_NOT_STANDARD.getModel());
		}
		if (sysOrgDomain.findByName(request.getOrgName()) != null) {
			throw new CommonBizException(ResultCode.ORG_NAME_EXIST.getModel());
		}
		if (sysOrgDomain.findByEnglishName(request.getOrgNameEn()) != null) {
			throw new CommonBizException(ResultCode.ORG_ENGLISHNAME_EXTST.getModel());
		}
		SysOrg org = new SysOrg();
		org.setName(request.getOrgName());
		org.setNameEn(request.getOrgNameEn());
		org.setRights("");
		Long orgId = sysOrgDomain.add(org);

		SysRole role = new SysRole();
		role.setRoleName("系统管理组");
		role.setParentId(0L);
		role.setIsDefault(true);
		role.setOrgId(orgId);
		role.setRights("");
		role.setCreatedDate(DateUtil.getCurrentDate());
		Long roleId = sysRoleDomain.addRole(role);

		SysUser user = new SysUser();
		user.setUsername(org.getNameEn() + "@admin");
		user.setName(org.getNameEn() + "@admin");
		user.setPassword(new BCryptPasswordEncoder().encode(org.getNameEn() + "123456"));
		user.setOrgId(orgId);
		user.setType(UserTypeEnum.ADMIN_USER.getCode());
		user.setRoleId(roleId);
		user.setLastLogin("");
		user.setIp("");
		user.setStatus("0");
		user.setSkin("default");
		user.setRights("");
		sysUserDomain.saveUser(user);
		return "";
	}

	@Override
	public String editOrg(EditOrgRequest request) {
		if (sysOrgDomain.findByName(request.getOrgName()) != null) {
			throw new CommonBizException(ResultCode.ORG_NAME_EXIST.getModel());
		}
		if (sysOrgDomain.findByEnglishName(request.getOrgNameEn()) != null) {
			throw new CommonBizException(ResultCode.ORG_ENGLISHNAME_EXTST.getModel());
		}
		SysOrg org = new SysOrg();
		org.setId(Long.valueOf(request.getOrgId()));
		org.setName(request.getOrgName());
		org.setNameEn(request.getOrgNameEn());
		sysOrgDomain.update(org);
		return "";
	}

	@Override
	public AuthcMenuVO authcMenu(OrgAuthcMenuRequest request) {
		AuthcMenuVO vo = new AuthcMenuVO();
		SysOrg org = sysOrgDomain.get(Long.valueOf(request.getOrgId()));
		List<String> idList = new ArrayList<>();
		List<Menu> menuList = new ArrayList<>();
		if(org.getType().equals("1")) {
			menuList = menuService.listAllMenu();
		}else {
			menuList = menuService.listAllServiceMenu();
			
		}
		menuList = this.readMenu(menuList, org.getRights(), idList);
		vo.setIdList(idList);
		vo.setMenuList(menuList);
		return vo;
	}

	@Override
	public String authcEdit(OrgAuthcEditRequest request) {
		SysOrg org = new SysOrg();
		org.setId(Long.valueOf(request.getOrgId()));
		String menuIds = request.getMenuIds();
		if (StringUtils.isEmpty(menuIds)) {
			org.setRights("");
			sysOrgDomain.update(org);
		} else {
			Set<Integer> set = new HashSet<>();
			List<String> menuIdList = Arrays.asList(menuIds.split(","));
			for (String menuId : menuIdList) {
				set.add(Integer.parseInt(menuId));
				SysMenu menu = sysMenuDomain.getMenuById(Integer.parseInt(menuId));
				set.addAll(JSON.parseArray(menu.getMenuParentJson(), Integer.class));
			}
			BigInteger right = RightsHelper.sumRights(set);
			org.setRights(right.toString());
			sysOrgDomain.update(org);
		}
		sysRoleDomain.UpdateDefaultRoleByOrgId(org);
		return "";
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

}
