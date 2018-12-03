package com.ud.basic.common.model.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import lombok.Data;

@Data
public class ValueData {

	private String name;
	private Object value;
	
	public ValueData() {
	}
	public ValueData(String name, Object value) {
		this.name = name;
		this.value = value;
	}
	
	public static List<ValueData> init(List<String> legends, Object defaultValue){
		List<ValueData> list = new ArrayList<>();
		for(String legend : legends) {
			ValueData data = new ValueData();
			data.setName(legend);
			data.setValue(defaultValue);
			list.add(data);
		}
		return list;
	}
	
	public static List<ValueData> init(List<String> legends, Object defaultValue, int times){
		List<ValueData> list = new ArrayList<>();
		for(int i = 0; i < times; i++) {
			for(String legend : legends) {
				ValueData data = new ValueData();
				data.setName(legend);
				data.setValue(defaultValue);
				list.add(data);
			}
		}
		return list;
	}
	
	public static Map<String, Object[]> buildMap(List<ValueData> records) {
		Map<String, Object[]> map = new HashMap<>();
		if(!CollectionUtils.isEmpty(records)) {
			for(ValueData item : records) {
				map.put(item.getName(), (Object[])item.getValue());
			}
		}
		return map;
	}
}
