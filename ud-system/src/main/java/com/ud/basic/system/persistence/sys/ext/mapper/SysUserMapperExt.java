package com.ud.basic.system.persistence.sys.ext.mapper;

import java.util.List;
import java.util.Map;

import com.ud.basic.system.controller.model.user.ListUserVO;

public interface SysUserMapperExt {

	List<ListUserVO> listUsers(Map<String, Object> map);

	int listAllUserByRoldId(String roleId);
}
