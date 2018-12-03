package com.ud.basic.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ud.basic.common.model.PageData;
import com.ud.basic.common.model.ResultBean;
import com.ud.basic.system.biz.service.OrgService;
import com.ud.basic.system.controller.model.org.AddOrgRequest;
import com.ud.basic.system.controller.model.org.EditOrgRequest;
import com.ud.basic.system.controller.model.org.ListOrgRequest;
import com.ud.basic.system.controller.model.org.OrgAuthcEditRequest;
import com.ud.basic.system.controller.model.org.OrgAuthcMenuRequest;
import com.ud.basic.system.controller.model.org.SysOrgVO;
import com.ud.basic.system.controller.model.role.AuthcMenuVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags={"组织接口"})
@Controller
@RequestMapping(value = "/org")
public class OrgController {

	@Autowired
	OrgService orgService;
	
	@ApiOperation(value = "组织列表")
	@RequestMapping(value="/ListOrgs",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<PageData<SysOrgVO>> ListOrgs(@RequestBody ListOrgRequest request){
		return new ResultBean<PageData<SysOrgVO>>(orgService.ListOrgs(request));
	}
	
	@ApiOperation(value = "新增组织")
	@RequestMapping(value="/addOrg",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<String> addOrg(@RequestBody AddOrgRequest request){
		return new ResultBean<String>(orgService.addOrg(request));
	}
	
	@ApiOperation(value = "编辑组织")
	@RequestMapping(value="/editOrg",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<String> editOrg(@RequestBody EditOrgRequest request){
		return new ResultBean<String>(orgService.editOrg(request));
	}
	
	@ApiOperation(value = "授权菜单")
	@RequestMapping(value="/authcMenu",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<AuthcMenuVO> authcMenu(@RequestBody OrgAuthcMenuRequest request){
		return new ResultBean<AuthcMenuVO>(orgService.authcMenu(request));
	}
	
	@ApiOperation(value = "授权编辑")
	@RequestMapping(value="/authcEdit",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<String> authcEdit(@RequestBody OrgAuthcEditRequest request){
		return new ResultBean<String>(orgService.authcEdit(request));
	}
	
}
