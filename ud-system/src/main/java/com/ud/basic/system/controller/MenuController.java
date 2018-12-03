package com.ud.basic.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ud.basic.common.model.ResultBean;
import com.ud.basic.system.biz.model.DO.SysMenuDO;
import com.ud.basic.system.biz.service.MenuService;
import com.ud.basic.system.controller.model.menu.AddMenuRequest;
import com.ud.basic.system.controller.model.menu.SysMenuVO;
import com.ud.basic.system.persistence.sys.ext.model.Menu;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags={"菜单接口"})
@Controller
@RequestMapping(value = "/menu")
public class MenuController {

	@Autowired
	MenuService menuService;
	
	@ApiOperation(value = "显示菜单列表")
	@RequestMapping(value="/list",method = {RequestMethod.POST})
	@ResponseBody
	public ResultBean<List<SysMenuVO>> list(@RequestBody SysMenuDO menuDO){
		return new ResultBean<List<SysMenuVO>>(menuService.list(menuDO));
	}
	
	@ApiOperation(value = "添加菜单")
	@RequestMapping(value="/add",method = {RequestMethod.POST})
	@ResponseBody
	public ResultBean<Void> add(@RequestBody AddMenuRequest request){
		return new ResultBean<Void>(menuService.add(request));
	}
	
	@ApiOperation(value = "删除菜单")
	@RequestMapping(value="/delete",method = {RequestMethod.POST})
	@ResponseBody
	public ResultBean<Void> delete(@RequestBody SysMenuDO menuDO){
		return new ResultBean<Void>(menuService.delete(menuDO));
	}
	
	@ApiOperation(value = "菜单详情")
	@RequestMapping(value="/detail",method = {RequestMethod.POST})
	@ResponseBody
	public ResultBean<SysMenuVO> detail(@RequestBody SysMenuDO menuDO){
		return new ResultBean<SysMenuVO>(menuService.detail(menuDO));
	}
	
	@ApiOperation(value = "修改菜单")
	@RequestMapping(value="/edit",method = {RequestMethod.POST})
	@ResponseBody
	public ResultBean<Void> edit(@RequestBody SysMenuDO menuDO){
		return new ResultBean<Void>(menuService.edit(menuDO));
	}
	
	@ApiOperation(value = "菜单树列表")
	@RequestMapping(value="/listAllMenu",method = {RequestMethod.GET})
	@ResponseBody
	public ResultBean<List<Menu>> listAllMenu(){
		return new ResultBean<List<Menu>>(menuService.listAllMenu());
	}
	
	@ApiOperation(value = "首页菜单列表")
	@RequestMapping(value="/indexMenuList",method = {RequestMethod.GET})
	@ResponseBody
	public ResultBean<List<Menu>> indexMenuList(){
		return new ResultBean<List<Menu>>(menuService.indexMenuList());
	}
}
