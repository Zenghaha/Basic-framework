package com.ud.basic.system.persistence.sys.auto.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.ud.basic.system.persistence.sys.auto.model.SysLoginimg;
import com.ud.basic.system.persistence.sys.auto.model.SysLoginimgExample;

public interface SysLoginimgMapper {
    int countByExample(SysLoginimgExample example);

    int deleteByExample(SysLoginimgExample example);

    int deleteByPrimaryKey(String loginimgId);

    int insert(SysLoginimg record);

    int insertSelective(SysLoginimg record);

    List<SysLoginimg> selectByExample(SysLoginimgExample example);

    SysLoginimg selectByPrimaryKey(String loginimgId);

    int updateByExampleSelective(@Param("record") SysLoginimg record, @Param("example") SysLoginimgExample example);

    int updateByExample(@Param("record") SysLoginimg record, @Param("example") SysLoginimgExample example);

    int updateByPrimaryKeySelective(SysLoginimg record);

    int updateByPrimaryKey(SysLoginimg record);
}