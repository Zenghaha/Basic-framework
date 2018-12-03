package com.ud.basic.common.model.view;

import java.util.List;

import lombok.Data;

/**
 * 基础曲线图数据
 * @author lzp
 * @date 2018年4月17日
 */
@Data
public class BasicLineChartVO {

	private List<String> xAxis;
	private List<Object> datas;


}
