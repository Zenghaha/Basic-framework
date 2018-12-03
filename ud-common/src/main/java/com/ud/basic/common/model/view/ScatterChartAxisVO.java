package com.ud.basic.common.model.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 轴状散点图
 * @author lzp
 * @date 2018年11月20日
 */
@Data
public class ScatterChartAxisVO {

	@ApiModelProperty(value = "轴")
	private List<String> axis;
	
	@ApiModelProperty(value = "轴数据")
	private List<String> axisDatas;
	
	@ApiModelProperty(value = "数据")
	private List<Object[]> datas;
	
	public void buildDatas(List<ValueData> list) {
		Map<String, Object[]> valueMap = ValueData.buildMap(list);
		List<Object[]> datas = new ArrayList<>();
		if(!CollectionUtils.isEmpty(this.axis)) {
			for(int i = 0; i < this.axis.size(); i++) {
				Object[] values = valueMap.get(this.axis.get(i));
				if(!CollectionUtils.isEmpty(this.axisDatas)) {
					for(int j = 0; j < this.axisDatas.size(); j++) {
						Double[] data = new Double[] {(double) i, (double)j, Double.valueOf(values[j].toString())};
						datas.add(data);
					}
				}
			}
			this.datas = datas;
		}
	}
	
}
