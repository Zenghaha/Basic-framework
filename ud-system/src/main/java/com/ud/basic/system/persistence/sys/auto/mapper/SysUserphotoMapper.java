package com.ud.basic.system.persistence.sys.auto.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.ud.basic.system.persistence.sys.auto.model.SysUserphoto;
import com.ud.basic.system.persistence.sys.auto.model.SysUserphotoExample;

public interface SysUserphotoMapper {
    int countByExample(SysUserphotoExample example);

    int deleteByExample(SysUserphotoExample example);

    int deleteByPrimaryKey(String userphotoId);

    int insert(SysUserphoto record);

    int insertSelective(SysUserphoto record);

    List<SysUserphoto> selectByExample(SysUserphotoExample example);

    SysUserphoto selectByPrimaryKey(String userphotoId);

    int updateByExampleSelective(@Param("record") SysUserphoto record, @Param("example") SysUserphotoExample example);

    int updateByExample(@Param("record") SysUserphoto record, @Param("example") SysUserphotoExample example);

    int updateByPrimaryKeySelective(SysUserphoto record);

    int updateByPrimaryKey(SysUserphoto record);
}