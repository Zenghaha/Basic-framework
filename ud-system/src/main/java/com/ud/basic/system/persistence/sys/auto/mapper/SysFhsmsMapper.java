package com.ud.basic.system.persistence.sys.auto.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.ud.basic.system.persistence.sys.auto.model.SysFhsms;
import com.ud.basic.system.persistence.sys.auto.model.SysFhsmsExample;

public interface SysFhsmsMapper {
    int countByExample(SysFhsmsExample example);

    int deleteByExample(SysFhsmsExample example);

    int deleteByPrimaryKey(String fhsmsId);

    int insert(SysFhsms record);

    int insertSelective(SysFhsms record);

    List<SysFhsms> selectByExample(SysFhsmsExample example);

    SysFhsms selectByPrimaryKey(String fhsmsId);

    int updateByExampleSelective(@Param("record") SysFhsms record, @Param("example") SysFhsmsExample example);

    int updateByExample(@Param("record") SysFhsms record, @Param("example") SysFhsmsExample example);

    int updateByPrimaryKeySelective(SysFhsms record);

    int updateByPrimaryKey(SysFhsms record);
}