package com.ud.basic.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ud.basic.common.model.PageData;
import com.ud.basic.common.model.ResultBean;
import com.ud.basic.system.biz.service.UserService;
import com.ud.basic.system.controller.model.user.DeleteUserRequest;
import com.ud.basic.system.controller.model.user.EditUserRequest;
import com.ud.basic.system.controller.model.user.ListUserVO;
import com.ud.basic.system.controller.model.user.ListUsersRequest;
import com.ud.basic.system.controller.model.user.SaveUserRequest;
import com.ud.basic.system.controller.model.user.SysUserVO;
import com.ud.basic.system.controller.model.user.UserDetailRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags={"用户接口"})
@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@ApiOperation(value = "查询登录用户信息")
	@RequestMapping(value = "/loginUser", method = {RequestMethod.GET})
	@ResponseBody
	public ResultBean<SysUserVO> getLoginUser(){
		return new ResultBean<SysUserVO>(userService.getLoginUser());
	}
	
	@ApiOperation(value = "系统用户列表")
	@RequestMapping(value="/listUsers",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<PageData<ListUserVO>> listUsers(@RequestBody ListUsersRequest request){
		return new ResultBean<PageData<ListUserVO>>(userService.listUsers(request));
	}
	
	@ApiOperation(value = "删除系统用户")
	@RequestMapping(value="/deleteUser",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<Void> deleteUser(@RequestBody DeleteUserRequest request){
		return new ResultBean<Void>(userService.deleteUser(request));
	}
	
	@ApiOperation(value = "新增系统用户")
	@RequestMapping(value="/saveUser",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<Void> saveUser(@RequestBody SaveUserRequest request){
		return new ResultBean<Void>(userService.saveUser(request));
	}
	
	@ApiOperation(value = "系统用户详情")
	@RequestMapping(value="/userDetail",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<SysUserVO> userDetail(@RequestBody UserDetailRequest request){
		return new ResultBean<SysUserVO>(userService.userDetail(request));
	}
	
	@ApiOperation(value = "编辑系统用户")
	@RequestMapping(value="/editUser",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<Void> editUser(@RequestBody EditUserRequest request){
		return new ResultBean<Void>(userService.editUser(request));
	}
	
}
