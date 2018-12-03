package com.ud.basic.system.biz.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.ud.basic.system.persistence.sys.auto.mapper.SysFileMapper;
import com.ud.basic.system.persistence.sys.auto.model.SysFile;
import com.ud.basic.system.persistence.sys.auto.model.SysFileExample;

@Service
public class FileDomain {

	@Autowired
	SysFileMapper SysFileMapper;
	
	public int add(SysFile sysFile) {
		if(null == sysFile.getStatus()) {
			sysFile.setStatus(1);
		}
		return SysFileMapper.insertSelective(sysFile);
	} 
	
	public SysFile getByFileCode(String fileCode) {
		SysFile res = null;
		SysFileExample example = new SysFileExample();
		example.createCriteria().andFileCodeEqualTo(fileCode);
		List<SysFile> list = SysFileMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(list)) {
			res = list.get(0);
		}
		return res;
	}
}
