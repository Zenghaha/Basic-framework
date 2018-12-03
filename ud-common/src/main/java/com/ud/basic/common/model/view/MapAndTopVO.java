package com.ud.basic.common.model.view;

import java.util.List;

import lombok.Data;

/**
 * 排行榜地图数据
 * @author lzp
 * @date 2018年4月17日
 */
@Data
public class MapAndTopVO {

	private List<ValueData> mapDatas;
	
	private List<ValueData> topDatas;
	
}
