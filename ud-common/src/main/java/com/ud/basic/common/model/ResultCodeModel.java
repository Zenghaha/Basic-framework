package com.ud.basic.common.model;

import lombok.Data;

@Data
public class ResultCodeModel {

	private String code;
	
	private String desc;
	
	public ResultCodeModel(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
