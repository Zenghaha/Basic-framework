package com.ud.basic.common.model.view;

import java.util.List;

import lombok.Data;

/**
 * 堆叠线图
 * @author lzp
 * @date 2018年4月17日
 */
@Data
public class StackedLineChartVO {

	private List<String> legends;
	private List<String> xAxis;
	private List<ValueData> datas;
}
