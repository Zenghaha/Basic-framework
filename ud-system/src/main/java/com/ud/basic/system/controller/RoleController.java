package com.ud.basic.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ud.basic.common.model.ResultBean;
import com.ud.basic.system.biz.model.DO.SysRoleDO;
import com.ud.basic.system.biz.service.RoleService;
import com.ud.basic.system.controller.model.role.AuthcEditRequest;
import com.ud.basic.system.controller.model.role.AuthcMenuVO;
import com.ud.basic.system.controller.model.role.RoleArrayRequest;
import com.ud.basic.system.controller.model.role.RoleListRequest;
import com.ud.basic.system.controller.model.role.RoleRequest;
import com.ud.basic.system.controller.model.role.SysRoleVO;
import com.ud.basic.system.controller.model.role.UserRolesVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags={"角色接口"})
@Controller
@RequestMapping(value = "/role")
public class RoleController {

	@Autowired
	RoleService roleService;
	
	@ApiOperation(value = "用户角色列表")
	@RequestMapping(value="/listAllRoles",method = {RequestMethod.GET})
	@ResponseBody
	public ResultBean<List<UserRolesVO>> listAllRoles(){
		return new ResultBean<List<UserRolesVO>>(roleService.listAllRoles());
	}
	
	@ApiOperation(value = "角色组列表")
	@RequestMapping(value="/groupList",method = {RequestMethod.POST})
	@ResponseBody
	public ResultBean<List<SysRoleVO>> groupList(@RequestBody RoleArrayRequest request){
		return new ResultBean<List<SysRoleVO>>(roleService.groupList(request));
	}
	
	@ApiOperation(value = "角色列表")
	@RequestMapping(value="/list",method = {RequestMethod.POST})
	@ResponseBody
	public ResultBean<List<SysRoleVO>> list(@RequestBody RoleListRequest request){
		return new ResultBean<List<SysRoleVO>>(roleService.list(request));
	}
	
	@ApiOperation(value = "新增角色")
	@RequestMapping(value="/add",method = {RequestMethod.POST})
	@ResponseBody
	public ResultBean<Void> add(@RequestBody SysRoleDO roleDO){
		return new ResultBean<Void>(roleService.add(roleDO));
	}
	
	@ApiOperation(value = "角色详情")
	@RequestMapping(value="/detail",method = {RequestMethod.POST})
	@ResponseBody
	public ResultBean<SysRoleVO> detail(@RequestBody RoleRequest request){
		return new ResultBean<SysRoleVO>(roleService.detail(request));
	}
	
	@ApiOperation(value = "编辑角色")
	@RequestMapping(value="/edit",method = {RequestMethod.POST})
	@ResponseBody
	public ResultBean<Void> edit(@RequestBody SysRoleDO roleDO){
		return new ResultBean<Void>(roleService.edit(roleDO));
	}
	
	@ApiOperation(value = "删除角色")
	@RequestMapping(value="/delete",method = {RequestMethod.POST})
	@ResponseBody
	public ResultBean<Void> delete(@RequestBody RoleRequest request){
		return new ResultBean<Void>(roleService.delete(request));
	}
	
	@ApiOperation(value = "菜单授权菜单")
	@RequestMapping(value="/authcMenu",method = {RequestMethod.POST})
	@ResponseBody
	public ResultBean<AuthcMenuVO> authcMenu(@RequestBody RoleRequest request){
		return new ResultBean<AuthcMenuVO>(roleService.authcMenu(request));
	}
	
	@ApiOperation(value = "编辑菜单权限")
	@RequestMapping(value="/authcEdit",method = {RequestMethod.POST})
	@ResponseBody
	public ResultBean<Void> authcEdit(@RequestBody AuthcEditRequest request){
		return new ResultBean<Void>(roleService.authcEdit(request));
	}
	
	
	
}
