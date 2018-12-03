package com.ud.basic.security.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ud.basic.common.model.ResultBean;
import com.ud.basic.common.util.LoginUtil;
import com.ud.basic.security.domain.LoginDomain;
import com.ud.basic.security.model.LoginUserDO;
import com.ud.basic.security.model.LoginUserVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags={"登录用户接口"})
@Controller
@RequestMapping(value = "/user")
public class LoginUserController {

	@Autowired
	LoginDomain loginDomain;
	
	@ApiOperation(value = "查询登录用户信息")
	@RequestMapping(value = "/loginUser", method = {RequestMethod.GET})
	@ResponseBody
	public ResultBean<LoginUserVO> getLoginUser(){
		LoginUserVO vo = null;
		String userName = LoginUtil.getLoginName();
		if (!StringUtils.isEmpty(userName)) {
			LoginUserDO userDO = loginDomain.getByUserName(userName);
			if (null != userDO) {
				vo = new LoginUserVO();
				BeanUtils.copyProperties(userDO, vo);
				vo.setUserId(userDO.getUserId().toString());
				vo.setRoleId(userDO.getRoleId().toString());
				vo.setOrgId(userDO.getOrgId().toString());
			}
		}
		return new ResultBean<LoginUserVO>(vo);
	}
}
