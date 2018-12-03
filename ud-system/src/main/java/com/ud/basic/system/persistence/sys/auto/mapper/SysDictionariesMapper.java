package com.ud.basic.system.persistence.sys.auto.mapper;

import com.ud.basic.system.persistence.sys.auto.model.SysDictionaries;
import com.ud.basic.system.persistence.sys.auto.model.SysDictionariesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDictionariesMapper {
    int countByExample(SysDictionariesExample example);

    int deleteByExample(SysDictionariesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysDictionaries record);

    int insertSelective(SysDictionaries record);

    List<SysDictionaries> selectByExample(SysDictionariesExample example);

    SysDictionaries selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysDictionaries record, @Param("example") SysDictionariesExample example);

    int updateByExample(@Param("record") SysDictionaries record, @Param("example") SysDictionariesExample example);

    int updateByPrimaryKeySelective(SysDictionaries record);

    int updateByPrimaryKey(SysDictionaries record);
}