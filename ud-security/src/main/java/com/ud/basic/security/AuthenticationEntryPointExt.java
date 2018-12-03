package com.ud.basic.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.ud.basic.common.enums.ResultCode;


public class AuthenticationEntryPointExt implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException) throws IOException {
    	response.setContentType("application/json; charset=utf-8");
    	response.getWriter().write("{\"code\":"+ResultCode.NOT_LOGIN.getCode()+",\"msg\":\""+ResultCode.NOT_LOGIN.getDesc()+"\"}");
    }
}