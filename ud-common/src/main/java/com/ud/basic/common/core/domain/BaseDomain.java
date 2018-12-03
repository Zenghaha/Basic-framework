package com.ud.basic.common.core.domain;

import java.util.List;

import com.github.pagehelper.Page;
import com.ud.basic.common.model.PageParameter;

public interface BaseDomain<T> {
	
	Long add(T model);
    T get(Long id);
    int update(T model);
    int delete(Long id);
    List<T> list(T model);
    Page<T> listPage(T model, PageParameter pageParam);
}
