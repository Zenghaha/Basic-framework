package com.ud.basic.system.biz.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.Page;
import com.ud.basic.common.core.exception.CommonBizException;
import com.ud.basic.common.enums.ResultCode;
import com.ud.basic.common.model.PageData;
import com.ud.basic.system.biz.domain.SysFhlogDomain;
import com.ud.basic.system.biz.domain.SysRoleDomain;
import com.ud.basic.system.biz.domain.SysUserDomain;
import com.ud.basic.system.biz.model.DO.SysUserDO;
import com.ud.basic.system.biz.service.UserService;
import com.ud.basic.system.controller.model.user.DeleteUserRequest;
import com.ud.basic.system.controller.model.user.EditUserRequest;
import com.ud.basic.system.controller.model.user.ListUserVO;
import com.ud.basic.system.controller.model.user.ListUsersRequest;
import com.ud.basic.system.controller.model.user.SaveUserRequest;
import com.ud.basic.system.controller.model.user.SysUserVO;
import com.ud.basic.system.controller.model.user.UserDetailRequest;
import com.ud.basic.system.persistence.sys.auto.model.SysUser;
import com.ud.basic.common.util.LoginUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	SysUserDomain sysUserDomain;

	@Autowired
	SysRoleDomain sysRoleDomain;

	@Autowired
	SysFhlogDomain sysFhlogDomain;

	@Override
	public SysUserVO getLoginUser() {
		SysUserVO vo = null;
		String userName = LoginUtil.getLoginName();
		if (StringUtils.isEmpty(userName)) {
			return vo;
		}
		SysUserDO userDO = sysUserDomain.getByUserName(userName);
		if (null != userDO) {
			vo = new SysUserVO();
			BeanUtils.copyProperties(userDO, vo);
			vo.setUserId(userDO.getUserId().toString());
			vo.setRoleId(userDO.getRoleId().toString());
			vo.setOrgId(userDO.getOrgId().toString());
		}
		return vo;
	}

	@Override
	public PageData<ListUserVO> listUsers(ListUsersRequest request) {
		PageData<ListUserVO> pd = new PageData<>();
		List<ListUserVO> list = new ArrayList<>();
		String owner = LoginUtil.getLoginOwner();
		Page<ListUserVO> page = sysUserDomain.listUsers(request,owner);
		for (ListUserVO vo : page) {
			list.add(vo);
		}
		pd.setTotal((int) page.getTotal());
		pd.setRows(list);
		return pd;
	}

	@Override
	public Void deleteUser(DeleteUserRequest request) {
		sysUserDomain.deleteUser(Long.valueOf(request.getUserId()));
		sysFhlogDomain.save(LoginUtil.getLoginName(), "删除系统用户:" + request);
		return null;
	}

	@Override
	public Void saveUser(SaveUserRequest request) {
		String regex=".*@.*";
		if(request.getUsername().matches(regex)) {
			throw new CommonBizException(ResultCode.USERNAME_NOT_STANDARD.getModel());
		}
		SysUser user = new SysUser();
		BeanUtils.copyProperties(request, user);
//		user.setUserId(String.valueOf(IdGenUtil.getId()));
		user.setLastLogin("");
		user.setIp("");
		user.setStatus("0");
		user.setSkin("default");
		user.setRights("");
		user.setOrgId(Long.valueOf(LoginUtil.getLoginOwner()));
		user.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
		if (null != sysUserDomain.getByUserName(request.getUsername())) {
			throw new CommonBizException(ResultCode.SYSUSER_EXIST.getModel());
		}
		sysUserDomain.saveUser(user);
		sysFhlogDomain.save(LoginUtil.getLoginName(), "新增系统用户:" + request.getUsername());
		return null;
	}

	@Override
	public SysUserVO userDetail(UserDetailRequest request) {
		SysUserVO vo = new SysUserVO();
		SysUser user = sysUserDomain.getByUserId(Long.valueOf(request.getUserId()));
		vo.setUserId(user.getUserId().toString());
		vo.setRoleId(user.getRoleId().toString());
		vo.setOrgId(user.getOrgId().toString());
		vo.setParentRoleId(sysRoleDomain.findById(user.getRoleId()).getParentId().toString());
		BeanUtils.copyProperties(user, vo);
		return vo;
	}

	@Override
	public Void editUser(EditUserRequest request) {
		SysUser user = new SysUser();
		BeanUtils.copyProperties(request, user);
		user.setUserId(Long.valueOf(request.getUserId()));
		user.setRoleId(Long.valueOf(request.getRoleId()));
		sysUserDomain.editUser(user);
		sysFhlogDomain.save(LoginUtil.getLoginName(), "编辑系统用户:" + request.getUsername());
		return null;
	}
}
