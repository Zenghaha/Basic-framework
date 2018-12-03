package com.ud.basic.common.model.view;

import java.util.ArrayList;
import java.util.List;


import lombok.Data;

@Data
public class TreeValueData {

	private String name;
	private Object value;
	private List<TreeValueData> children = new ArrayList<>();
	
	
	public TreeValueData() {
	}
	public TreeValueData(String name, Object value) {
		this.name = name;
		this.value = value;
	}
}
