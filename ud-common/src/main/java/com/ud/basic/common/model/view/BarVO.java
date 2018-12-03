package com.ud.basic.common.model.view;

import java.util.List;

import lombok.Data;

/**
 * 柱状图数据
 *
 * @author lzp
 * @date 2018年4月17日
 */
@Data
public class BarVO {

    private List<String> xAxis;
    private List<Object> datas;


}
