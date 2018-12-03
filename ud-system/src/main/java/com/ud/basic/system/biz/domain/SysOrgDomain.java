package com.ud.basic.system.biz.domain;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ud.basic.common.model.PageParameter;
import com.ud.basic.system.persistence.sys.auto.mapper.SysOrgMapper;
import com.ud.basic.system.persistence.sys.auto.model.SysOrg;
import com.ud.basic.system.persistence.sys.auto.model.SysOrgExample;
import com.ud.basic.system.persistence.sys.ext.mapper.SysOrgMapperExt;
import com.ud.basic.common.core.domain.BaseDomain;

@Service
public class SysOrgDomain implements BaseDomain<SysOrg>{

	@Autowired
	SysOrgMapper sysOrgMapper;
	
	@Autowired
	SysOrgMapperExt sysOrgExtMapper;
	
	@Override
	public Long add(SysOrg model) {
		if(StringUtils.isEmpty(model.getType()))
			model.setType("2");
		model.setCreateTime(Calendar.getInstance().getTime());
		sysOrgMapper.insertSelective(model);
		return model.getId();
	}

	@Override
	public SysOrg get(Long id) {
		return sysOrgMapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(SysOrg model) {
		return sysOrgMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Page listPage(SysOrg model, PageParameter pageParam) {
		Page<SysOrg> page = PageHelper.startPage(pageParam.getPage(),pageParam.getRows());
		SysOrgExample example = new SysOrgExample();
		sysOrgMapper.selectByExample(example);
		return page;
	}

	public SysOrg findByName(String orgName) {
		return sysOrgExtMapper.findByName(orgName);
	}
	
	public SysOrg findByEnglishName(String orgEnglishName) {
		return sysOrgExtMapper.findByEnglishName(orgEnglishName);
	}

	@Override
	public List<SysOrg> list(SysOrg model) {
		// TODO Auto-generated method stub
		return null;
	}

}
