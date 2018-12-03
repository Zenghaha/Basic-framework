package com.ud.basic.common.model.view;

import java.util.List;

import lombok.Data;

/**
 * 嵌套馅饼图数据
 * @author lzp
 * @date 2018年4月17日
 */
@Data
public class NestedPiesVO {

	private List<String> innerLegends;
	private List<String> outerLegends;
	private List<ValueData> innerDatas;
	private List<ValueData> outerDatas;
}
