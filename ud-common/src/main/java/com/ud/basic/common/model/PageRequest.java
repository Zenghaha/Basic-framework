package com.ud.basic.common.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PageRequest extends Request{

	@ApiModelProperty(value = "页码")
	private int currentPage = 1;
	
	@ApiModelProperty(value = "页面大小")
	private int showCount = 10;
}
