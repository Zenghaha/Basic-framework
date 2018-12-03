package com.ud.basic.common.model.view;

import java.util.List;

import lombok.Data;

/**
 * 堆叠柱状图
 * @author lzp
 * @date 2018年5月29日
 */
@Data
public class StackedBarVO {

	private List<String> legends;
	private List<String> xAxis;
    private List<ValueData> datas;
}
