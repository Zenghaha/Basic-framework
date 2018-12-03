package com.ud.basic.system.persistence.sys.ext.mapper;

import java.util.List;
import java.util.Map;

import com.ud.basic.system.controller.model.role.SysRoleVO;
import com.ud.basic.system.persistence.sys.auto.model.SysOrg;

public interface SysRoleMapperExt {

	List<SysRoleVO> listAllRoles(Map<String, String> map);

	List<SysRoleVO> listAllRolesByPId(String roleId);

	void setAllRights(Map<String, Object> map);

	List<SysRoleVO> listAllRoleArrByOrgId(String orgId);

	List<SysRoleVO> listAllRolesByOrgId(Map<String, String> map);

	void UpdateDefaultRoleByOrgId(SysOrg org);
}
