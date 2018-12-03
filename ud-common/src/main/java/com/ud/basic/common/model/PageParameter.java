package com.ud.basic.common.model;

import lombok.Data;

@Data
public class PageParameter {

	private int page = 1;
	
	private int rows = 10;
	
	public PageParameter() {
	}
	
	public PageParameter(Integer page, Integer rows) {
		this.page = page;
		this.rows = rows;
	}
}
