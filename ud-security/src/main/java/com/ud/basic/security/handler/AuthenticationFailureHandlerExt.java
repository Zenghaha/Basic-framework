package com.ud.basic.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.ud.basic.common.enums.ResultCode;
import com.ud.basic.security.exception.BadAuthCodeException;


@Component
public class AuthenticationFailureHandlerExt extends SimpleUrlAuthenticationFailureHandler {
	
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException{
		response.setContentType("application/json; charset=utf-8");
		if(exception instanceof UsernameNotFoundException)
	    	response.getWriter().write("{\"code\":\""+ResultCode.LOGIN_USER_NOT_EXIST.getCode()
	    							+"\",\"msg\":\""+ResultCode.LOGIN_USER_NOT_EXIST.getDesc()+"\"}");
		else if(exception instanceof BadCredentialsException)
			response.getWriter().write("{\"code\":\""+ResultCode.LOGIN_PWD_ERROR.getCode()
									+"\",\"msg\":\""+ResultCode.LOGIN_PWD_ERROR.getDesc()+"\"}");
		else if(exception instanceof LockedException)
			response.getWriter().write("{\"code\":\""+ResultCode.LOGIN_USER_LOCKED.getCode()
									+"\",\"msg\":\""+ResultCode.LOGIN_USER_LOCKED.getDesc()+"\"}");
		else if(exception instanceof BadAuthCodeException)
			response.getWriter().write("{\"code\":\""+ResultCode.LOGIN_AUTHCODE_ERROR.getCode()
									+"\",\"msg\":\""+ResultCode.LOGIN_AUTHCODE_ERROR.getDesc()+"\"}");
		else
			response.getWriter().write("{\"code\":\""+ResultCode.LOGIN_OTHER_ERROR.getCode()
									+"\",\"msg\":\""+exception.getMessage()+"\"}");
		
	}
}
