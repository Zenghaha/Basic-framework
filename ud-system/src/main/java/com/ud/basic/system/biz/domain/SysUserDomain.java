package com.ud.basic.system.biz.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ud.basic.system.biz.model.DO.SysUserDO;
import com.ud.basic.system.controller.model.user.ListUserVO;
import com.ud.basic.system.controller.model.user.ListUsersRequest;
import com.ud.basic.system.persistence.sys.auto.mapper.SysUserMapper;
import com.ud.basic.system.persistence.sys.auto.model.SysRole;
import com.ud.basic.system.persistence.sys.auto.model.SysUser;
import com.ud.basic.system.persistence.sys.auto.model.SysUserExample;
import com.ud.basic.system.persistence.sys.ext.mapper.SysUserMapperExt;
import com.ud.basic.common.core.exception.CommonBizException;
import com.ud.basic.common.enums.ResultCode;

@Service
public class SysUserDomain {

	@Autowired
	SysUserMapper sysUserMapper;
	@Autowired
	SysUserMapperExt sysUserExtMapper;
	@Autowired
	SysRoleDomain sysRoleDomain;
	
	public SysUserDO getByUserName(String userName) {
		SysUserDO userDO = null;
		SysUserExample example = new SysUserExample();
		example.createCriteria().andUsernameEqualTo(userName);
		List<SysUser> list = sysUserMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(list)) {
			userDO = new SysUserDO();
			BeanUtils.copyProperties(list.get(0), userDO);
			
			SysRole role = sysRoleDomain.findById(Long.valueOf(userDO.getRoleId()));
			userDO.setCompanyName(role.getCompanyName());
			userDO.setDepartment(role.getDepartment());
			userDO.setPosition(role.getPosition());
		}
		return userDO;
	}

	public Page<ListUserVO> listUsers(ListUsersRequest request,String owner) {
		Page<ListUserVO> page = PageHelper.startPage(request.getCurrentPage(),request.getShowCount());
		Map<String, Object> map = new HashMap();
		if(!StringUtils.isEmpty(request.getKeywords())){
			map.put("keywords", request.getKeywords());
		}
		if(!StringUtils.isEmpty(request.getRoleId())){
			map.put("roleId", request.getRoleId());
		}
		if(!StringUtils.isEmpty(owner)){
			map.put("owner", owner);
		}
		if(!StringUtils.isEmpty(request.getLastLoginEnd())){
			map.put("lastLoginStart", request.getLastLoginEnd()+" 00:00:00");
		}
		if(!StringUtils.isEmpty(request.getLastLoginStart())){
			map.put("lastLoginEnd", request.getLastLoginStart()+" 00:00:00");
		}
		sysUserExtMapper.listUsers(map);
		return page;
	}

	public void deleteUser(Long userId) {
		if(userId == 1){
			return;
		}
		sysUserMapper.deleteByPrimaryKey(userId);
	}

	public void saveUser(SysUser user) {
		if(StringUtils.isEmpty(user.getType()))
			user.setType("1");
		sysUserMapper.insertSelective(user);
	}

	public SysUser getByUserId(Long userId) {
		return sysUserMapper.selectByPrimaryKey(userId);
	}

	public void editUser(SysUser user) {
		sysUserMapper.updateByPrimaryKeySelective(user);
	}

	public int listAllUserByRoldId(String roleId) {
		return sysUserExtMapper.listAllUserByRoldId(roleId);
	}
}
