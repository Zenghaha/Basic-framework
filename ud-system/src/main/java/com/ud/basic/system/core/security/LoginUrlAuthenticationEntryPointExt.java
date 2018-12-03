package com.ud.basic.system.core.security;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.PortMapper;
import org.springframework.security.web.PortMapperImpl;
import org.springframework.security.web.PortResolver;
import org.springframework.security.web.PortResolverImpl;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.ud.basic.common.enums.ResultCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginUrlAuthenticationEntryPointExt extends LoginUrlAuthenticationEntryPoint{

	private PortMapper portMapper = new PortMapperImpl();

	private PortResolver portResolver = new PortResolverImpl();

	private String loginFormUrl;

	private boolean forceHttps = false;

	private boolean useForward = false;

	private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	public LoginUrlAuthenticationEntryPointExt(String loginFormUrl) {
		super(loginFormUrl);
	}
	
	/**
	 * Performs the redirect (or forward) to the login form URL.
	 */
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		response.setContentType("application/json; charset=utf-8");
    	response.getWriter().write("{\"code\":"+ResultCode.NOT_LOGIN.getCode()+",\"msg\":\""+ResultCode.NOT_LOGIN.getDesc()+"\"}");
	}

}
