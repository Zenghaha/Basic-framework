package com.ud.basic.common.core.exception;

import com.ud.basic.common.model.ResultCodeModel;

import lombok.Data;

/**
 * 
 * @author lzp
 * @date 2017年10月20日
 */
@Data
public class BaseBizException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	ResultCodeModel codeModel;

    String errorCode;

    String errorMsg;

    /** 除了错误码本身描述的提示信息外，额外补充的信息 */
    private String extraMsg;

    /** 错误信息模板 */
    private final static String MSG_TEMPLATE = "错误码:{0}, 描述:{1}, 异常信息:{2}";


    /**
     * 构造器
     */
    public BaseBizException() {
        super();
    }

    /**
     * 构造器，含异常信息
     *
     * @param e 支付业务异常
     */
    public BaseBizException(BaseBizException e) {
        super(e);
        this.codeModel = e.getCodeModel();
        this.errorCode = e.getCodeModel().getCode();
        this.errorMsg = e.getCodeModel().getDesc();
    }

    /**
     * 构造器，含错误明细码枚举
     *
     * @param codeModel  错误码
     */
    public BaseBizException(ResultCodeModel codeModel) {
        super(codeModel.getDesc());
        this.codeModel = codeModel;
        this.errorCode = codeModel.getCode();
        this.errorMsg = codeModel.getDesc();
    }

    /**
     * 构造器，含错误明细码枚举、自定义错误信息
     *
     * @param codeModel  错误码
     * @param extraMsg  错误描述
     */
    public BaseBizException(ResultCodeModel codeModel, String extraMsg) {
        super(extraMsg == null? codeModel.getDesc():codeModel.getDesc()+"-"+extraMsg);
        this.codeModel = codeModel;
        this.errorCode = codeModel.getCode();
        this.errorMsg = codeModel.getDesc();
        this.extraMsg = extraMsg;
    }

    /**
     * 构造器，含错误明细码枚举、异常
     *
     * @param codeModel  错误码
     * @param cause 异常
     */
    public BaseBizException(ResultCodeModel codeModel, Throwable cause) {
        super(codeModel.getDesc(), cause);
        this.codeModel = codeModel;
        this.errorCode = codeModel.getCode();
        this.errorMsg = codeModel.getDesc();
    }
    public BaseBizException(ResultCodeModel codeModel, Throwable cause, String extraMsg) {
        super(codeModel.getDesc()+"-"+extraMsg, cause);
        this.codeModel = codeModel;
        this.errorCode = codeModel.getCode();
        this.errorMsg = codeModel.getDesc();
        this.extraMsg = extraMsg;
    }

    /**
     * 组装错误信息
     *
     * @return             错误信息详细描述
     */
    public String getMessage() {
        return this.extraMsg ==null?this.errorMsg:this.errorMsg+"-"+this.extraMsg;
    }
}
