package com.ud.basic.common.core.exception;

import com.ud.basic.common.model.ResultCodeModel;

/**
 * 
 * @author lzp
 * @date 2017年10月20日
 */
public class CommonBizException extends BaseBizException {

	private static final long serialVersionUID = 1L;

	/**
     * 构造器 含错误码
     *
     * @param codeModel 错误码
     */
    public CommonBizException(ResultCodeModel codeModel) {
        super(codeModel);
    }

    /**
     * 构造器 含错误码、错误描述
     *
     * @param codeModel  错误码
     * @param  extraMsg 错误描述
     */
    public CommonBizException(ResultCodeModel codeModel, String extraMsg) {
        super(codeModel, extraMsg);
    }

    /**
     * 构造器 含错误码、异常
     *
     * @param codeModel  错误码
     * @param cause 异常
     */
    public CommonBizException(ResultCodeModel codeModel, Throwable cause) {
        super(codeModel, cause);
    }

    public CommonBizException(ResultCodeModel codeModel, Throwable cause, String extraMsg) {
        super(codeModel, cause,extraMsg);
    }

}
