package com.ud.basic.system.core.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.ud.basic.system.core.security.model.UserDetailsExt;


@Component
public class AuthenticationSuccessHandlerExt extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
            HttpServletResponse response, Authentication authentication)
            throws ServletException, IOException {
    	
    	UserDetailsExt userDetails = (UserDetailsExt) authentication.getPrincipal();
    	String theData = "\"data\":{\"userName\":\""+userDetails.getUsername()+"\"}";
    	response.setContentType("application/json; charset=utf-8");
    	response.getWriter().write("{\"code\":\"0000\",\"msg\":\"登录成功\","+theData+"}");
        clearAuthenticationAttributes(request);
    }
}
