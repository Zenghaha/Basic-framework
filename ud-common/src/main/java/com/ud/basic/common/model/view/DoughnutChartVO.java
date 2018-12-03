package com.ud.basic.common.model.view;

import java.util.List;

import lombok.Data;

/**
 * 油炸圈饼图数据
 * @author lzp
 * @date 2018年4月17日
 */
@Data
public class DoughnutChartVO {
	
	private List<String> legends;
	private List<ValueData> datas;
}
