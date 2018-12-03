package com.ud.basic.system.biz.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ud.basic.system.persistence.sys.auto.mapper.SysFhlogMapper;
import com.ud.basic.system.persistence.sys.auto.model.SysFhlog;
import com.ud.basic.common.util.DateUtil;
import com.ud.basic.common.util.UuidUtil;

@Service
public class SysFhlogDomain {

	@Autowired
	SysFhlogMapper sysFhlogMapper;

	public void save(String userName, String content) {
		SysFhlog log = new SysFhlog();
		log.setContent(content);
		log.setUsername(userName);
		log.setCztime(DateUtil.getNowTimeFormat(DateUtil.defaultPattern));
		log.setFhlogId(UuidUtil.getUUID32());
		sysFhlogMapper.insertSelective(log);
	}

	
}
