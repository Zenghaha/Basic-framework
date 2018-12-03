package com.ud.basic.system.persistence.sys.auto.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.ud.basic.system.persistence.sys.auto.model.SysAppUser;
import com.ud.basic.system.persistence.sys.auto.model.SysAppUserExample;

public interface SysAppUserMapper {
    int countByExample(SysAppUserExample example);

    int deleteByExample(SysAppUserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(SysAppUser record);

    int insertSelective(SysAppUser record);

    List<SysAppUser> selectByExample(SysAppUserExample example);

    SysAppUser selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") SysAppUser record, @Param("example") SysAppUserExample example);

    int updateByExample(@Param("record") SysAppUser record, @Param("example") SysAppUserExample example);

    int updateByPrimaryKeySelective(SysAppUser record);

    int updateByPrimaryKey(SysAppUser record);
}