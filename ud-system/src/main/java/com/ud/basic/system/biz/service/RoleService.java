package com.ud.basic.system.biz.service;

import java.util.List;

import com.ud.basic.system.biz.model.DO.SysRoleDO;
import com.ud.basic.system.controller.model.role.AuthcEditRequest;
import com.ud.basic.system.controller.model.role.AuthcMenuVO;
import com.ud.basic.system.controller.model.role.RoleArrayRequest;
import com.ud.basic.system.controller.model.role.RoleListRequest;
import com.ud.basic.system.controller.model.role.RoleRequest;
import com.ud.basic.system.controller.model.role.SysRoleVO;
import com.ud.basic.system.controller.model.role.UserRolesVO;

public interface RoleService {

	List<UserRolesVO> listAllRoles();

	List<SysRoleVO> list(RoleListRequest request);

	Void add(SysRoleDO roleDO);

	SysRoleVO detail(RoleRequest request);

	Void edit(SysRoleDO roleDO);

	Void delete(RoleRequest request);

	AuthcMenuVO authcMenu(RoleRequest request);

	Void authcEdit(AuthcEditRequest request);

	List<SysRoleVO> groupList(RoleArrayRequest request);

}
