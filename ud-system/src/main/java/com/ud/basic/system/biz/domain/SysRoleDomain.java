package com.ud.basic.system.biz.domain;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ud.basic.system.controller.model.role.SysRoleVO;
import com.ud.basic.system.persistence.sys.auto.mapper.SysRoleMapper;
import com.ud.basic.system.persistence.sys.auto.model.SysOrg;
import com.ud.basic.system.persistence.sys.auto.model.SysRole;
import com.ud.basic.system.persistence.sys.ext.mapper.SysRoleMapperExt;

@Service
public class SysRoleDomain {

	@Autowired
	SysRoleMapper sysRoleMapper;
	
	@Autowired
	SysRoleMapperExt sysRoleExtMapper;

	public List<SysRoleVO> listAllRolesByPId(String roleId) {
		return sysRoleExtMapper.listAllRolesByPId(roleId);
	}

	public SysRole findById(Long roleId) {
		return sysRoleMapper.selectByPrimaryKey(roleId);
	}

	public Long addRole(SysRole role) {
		if(null == role.getIsDefault())
			role.setIsDefault(false);
		sysRoleMapper.insertSelective(role);
		return role.getRoleId();
	}

	public void editRole(SysRole role) {
		sysRoleMapper.updateByPrimaryKeySelective(role);
	}

	public void deleteRole(Long roleId) {
		sysRoleMapper.deleteByPrimaryKey(roleId);
	}

	public void setAllRights(Map<String, Object> map) {
		sysRoleExtMapper.setAllRights(map);
	}

	public List<SysRoleVO> listAllRoleArrByOrgId(String orgId) {
		return sysRoleExtMapper.listAllRoleArrByOrgId(orgId);
	}

	public List<SysRoleVO> listAllRolesByOrgId(Map<String, String> map) {
		return sysRoleExtMapper.listAllRolesByOrgId(map);
	}

	public void UpdateDefaultRoleByOrgId(SysOrg org) {
		sysRoleExtMapper.UpdateDefaultRoleByOrgId(org);
	}


}
