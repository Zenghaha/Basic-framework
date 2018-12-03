package com.ud.basic.common.model;

import java.io.Serializable;

import com.ud.basic.common.enums.ResultCode;

import lombok.Data;

@Data
public class ResultBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String code = ResultCode.SUCCESS.getCode();
	private String msg = ResultCode.SUCCESS.getDesc();
	private T data;
	
	
	public ResultBean() {
	    super();
	  }

	  public ResultBean(T data) {
	    super();
	    this.data = data;
	  }

	  public ResultBean(Throwable e) {
	    super();
	    this.msg = e.toString();
	    this.code = ResultCode.SYS_EXCEPTION.getCode();
	  }
	
}
