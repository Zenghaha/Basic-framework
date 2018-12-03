package com.ud.basic.system.persistence.sys.auto.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.ud.basic.system.persistence.sys.auto.model.SysMenu;
import com.ud.basic.system.persistence.sys.auto.model.SysMenuExample;

public interface SysMenuMapper {
    int countByExample(SysMenuExample example);

    int deleteByExample(SysMenuExample example);

    int deleteByPrimaryKey(Integer menuId);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    List<SysMenu> selectByExample(SysMenuExample example);

    SysMenu selectByPrimaryKey(Integer menuId);

    int updateByExampleSelective(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    int updateByExample(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
}