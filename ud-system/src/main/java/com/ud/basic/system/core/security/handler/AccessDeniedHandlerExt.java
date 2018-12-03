package com.ud.basic.system.core.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.ud.basic.common.enums.ResultCode;

@Component
public class AccessDeniedHandlerExt implements AccessDeniedHandler{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {

		response.setContentType("application/json; charset=utf-8");
		response.getWriter().write("{\"code\":\""+ResultCode.LOGIN_NO_AUTH.getCode()
								+"\",\"msg\":\""+ResultCode.LOGIN_NO_AUTH.getDesc()+"\"}");
	}

}
