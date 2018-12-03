package com.ud.basic.system.biz.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.ud.basic.system.persistence.sys.auto.mapper.SysMenuMapper;
import com.ud.basic.system.persistence.sys.auto.mapper.SysResourceMapper;
import com.ud.basic.system.persistence.sys.auto.mapper.SysRoleMapper;
import com.ud.basic.system.persistence.sys.auto.model.SysMenu;
import com.ud.basic.system.persistence.sys.auto.model.SysResource;
import com.ud.basic.system.persistence.sys.auto.model.SysResourceExample;
import com.ud.basic.system.persistence.sys.auto.model.SysRole;
import com.ud.basic.system.util.RightsHelper;

@Service
public class SysResourceDomain {

	@Autowired
	SysResourceMapper sysMenuResourceMapper;
	@Autowired
	SysRoleMapper sysRoleMapper;
	@Autowired
	SysMenuMapper sysMenuMapper;
	
	public List<SysResource> getResources(Long refId) {
		SysResourceExample example = new SysResourceExample();
		example.createCriteria().andRefIdEqualTo(refId);
		return sysMenuResourceMapper.selectByExample(example);
	}
	
	public List<SysResource> getByRole(Long roleId){
		List<SysResource> list = new ArrayList<>();
		SysRole role = sysRoleMapper.selectByPrimaryKey(roleId);
		List<SysMenu> menus = sysMenuMapper.selectByExample(null);
		for(SysMenu m : menus) {
			boolean ishas = RightsHelper.testRights(role.getRights(), String.valueOf(m.getMenuId()));
			if(ishas && "1".equals(m.getMenuState().toString())) {
				List<SysResource> resources = this.getResources(Long.valueOf(m.getMenuId()));
				if(!CollectionUtils.isEmpty(resources)) {
					list.addAll(resources);
				}
			}
		}
		return list;
	}
	
	public List<SysResource> getAll(){
		return sysMenuResourceMapper.selectByExample(null);
	}
}
