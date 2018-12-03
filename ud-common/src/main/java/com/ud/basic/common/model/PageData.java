package com.ud.basic.common.model;

import java.util.HashMap;
import java.util.List;

import lombok.Data;

@Data
public class PageData<T> extends HashMap<String, Object>{
	
	public PageData() {
		this.put("total", 0);
		this.put("rows", null);
	}
	
	public void setTotal(int total) {
		this.put("total", total);
	}
	
	public int getTotal() {
		return (int)this.get("total");
	}
	
	public void setRows(List<T> rows) {
		this.put("rows", rows);
	}
	
	public List<T> getRows(){
		return (List<T>)this.get("rows");
	}
}
