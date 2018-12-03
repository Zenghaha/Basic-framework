package com.ud.basic.system.persistence.sys.auto.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.ud.basic.system.persistence.sys.auto.model.SysFhlog;
import com.ud.basic.system.persistence.sys.auto.model.SysFhlogExample;

public interface SysFhlogMapper {
    int countByExample(SysFhlogExample example);

    int deleteByExample(SysFhlogExample example);

    int deleteByPrimaryKey(String fhlogId);

    int insert(SysFhlog record);

    int insertSelective(SysFhlog record);

    List<SysFhlog> selectByExample(SysFhlogExample example);

    SysFhlog selectByPrimaryKey(String fhlogId);

    int updateByExampleSelective(@Param("record") SysFhlog record, @Param("example") SysFhlogExample example);

    int updateByExample(@Param("record") SysFhlog record, @Param("example") SysFhlogExample example);

    int updateByPrimaryKeySelective(SysFhlog record);

    int updateByPrimaryKey(SysFhlog record);
}