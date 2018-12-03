package com.ud.basic.common.model.view;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 基础曲线柱状图数据
 * @author lzp
 * @date 2018年4月17日
 */
@Data
public class BasicLineBarChartVO {
	@ApiModelProperty(value = "图例数据")
	private List<String> legends;
	
	@ApiModelProperty(value = "X轴数据")
	private List<String> xAxis;
	
	@ApiModelProperty(value = "折线图数据")
	private List<Object> lineDatas;
	
	@ApiModelProperty(value ="柱状图数据")
	private List<Object> barDatas;
}
