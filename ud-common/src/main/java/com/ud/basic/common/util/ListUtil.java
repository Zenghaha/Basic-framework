package com.ud.basic.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;

public class ListUtil {

	public static <T> List<T> transform(Collection sourceList, Class<T> type){
        ArrayList<T> targetList = new ArrayList<>();
        try {
            for(Object object : sourceList){
                T t = type.newInstance();
                BeanUtils.copyProperties(object,t);
                targetList.add(t);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return targetList;
    }
	
	public static <T> List<T> ListSplit(List<T> list,int rows,int page) {  
        List<T> newList=null;  
        int total=list.size();  
        newList=list.subList(rows*(page-1), ((rows*page)>total?total:(rows*page)));  
        return newList;  
    }
}
