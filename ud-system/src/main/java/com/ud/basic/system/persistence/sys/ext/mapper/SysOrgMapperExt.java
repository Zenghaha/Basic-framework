package com.ud.basic.system.persistence.sys.ext.mapper;

import com.ud.basic.system.persistence.sys.auto.model.SysOrg;

public interface SysOrgMapperExt {

	SysOrg findByName(String orgName);

	SysOrg findByEnglishName(String orgEnglishName);

}
