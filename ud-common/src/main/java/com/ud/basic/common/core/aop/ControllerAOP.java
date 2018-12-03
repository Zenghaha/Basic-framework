package com.ud.basic.common.core.aop;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.ud.basic.common.core.exception.CommonBizException;
import com.ud.basic.common.enums.ResultCode;
import com.ud.basic.common.model.Request;
import com.ud.basic.common.model.ResultBean;
import com.ud.basic.common.util.ParamValidator;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Configuration
@Component
@Slf4j
public class ControllerAOP {
	
	@Around(value = "execution(public com.ud.basic.common.model.ResultBean *(..)) &&"
			+ " args(..)")
	public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
		ResultBean<?> result;
		try {
			String param = pjp.getArgs() == null ? "" : JSON.toJSONString(pjp.getArgs());
			HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			log.info("开始服务: URI="+req.getRequestURI()+" , param=" + param);
			if(null != pjp.getArgs() && pjp.getArgs().length > 0) {
				for(Object o : pjp.getArgs()) {
					if(o instanceof Request) {
						ParamValidator.validate(o);
					}
				}
			}
			result = (ResultBean<?>) pjp.proceed();
			log.info("结束服务: URI="+req.getRequestURI()+" , result=" + result);
		} catch (Throwable e) {
			result = handlerException(pjp, e);
		}
		return result;
	}

	private ResultBean<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
		ResultBean<?> result = new ResultBean<>();
		// 已知异常
		if(e instanceof CommonBizException) {
			CommonBizException ex = (CommonBizException) e;
			String extMsg = ex.getExtraMsg() == null ? "" : "[" + ex.getExtraMsg() + "]";
			log.info(pjp.getSignature() + " BizError: " + ex.getErrorCode() + "-" + ex.getErrorMsg() + extMsg);
			result.setCode(ex.getErrorCode());
			result.setMsg(ex.getErrorMsg() + extMsg);
		}else{
			log.error(pjp.getSignature() + " error: ", e);
			//TODO 未知的异常，应该格外注意，可以发送邮件通知等
			result.setCode(ResultCode.SYS_EXCEPTION.getCode());
			result.setMsg(e.toString());
		}
		return result;
	}
}
