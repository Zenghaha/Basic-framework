package com.ud.basic.common.model.view;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 矩形树图
 * @author lzp
 * @date 2018年11月20日
 */
@Data
public class TreeMapVO {

	@ApiModelProperty(value = "数据")
	private List<TreeValueData> datas;
}
