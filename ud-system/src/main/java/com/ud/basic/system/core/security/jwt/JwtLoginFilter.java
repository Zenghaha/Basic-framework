package com.ud.basic.system.core.security.jwt;


import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.alibaba.fastjson.JSON;
import com.ud.basic.common.util.DateUtil;
import com.ud.basic.system.core.security.handler.AuthenticationFailureHandlerExt;
import com.ud.basic.system.core.security.model.UserDetailsExt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
* 验证用户名密码正确后，生成一个token，并将token返回给客户端
* 该类继承自UsernamePasswordAuthenticationFilter，重写了其中的2个方法
* attemptAuthentication ：接收并解析用户凭证。
* successfulAuthentication ：用户成功登录后，这个方法会被调用，我们在这个方法里生成token。
*/
public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {
	
	private UserDetailsService userDetailsService;

   private AuthenticationManager authenticationManager;
   
   private String salt;

   public JwtLoginFilter(AuthenticationManager authenticationManager, UserDetailsService userDetailsService,String salt) {
	   super.setAuthenticationFailureHandler(new AuthenticationFailureHandlerExt());
       this.authenticationManager = authenticationManager;
       this.userDetailsService = userDetailsService;
       this.salt = salt;
   }

   // 接收并解析用户凭证
   @Override
   public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
	   UserDetails user = userDetailsService.loadUserByUsername(req.getParameter("username"));
       return authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(
            		   user,
            		   req.getParameter("password"),
            		   user.getAuthorities())
    		   );
   }

   // 用户成功登录后，这个方法会被调用，我们在这个方法里生成token
   @Override
   protected void successfulAuthentication(HttpServletRequest req,
                                           HttpServletResponse res,
                                           FilterChain chain,
                                           Authentication auth) throws IOException, ServletException {
	   UserDetailsExt userDetails = (UserDetailsExt) auth.getPrincipal();
	   List<String> subs = Arrays.asList(userDetails.getUsername(), userDetails.getOrgId());
	   String sub = JSON.toJSONString(subs);
	   String token = Jwts.builder()
	           .setSubject(sub)
	           .setExpiration(DateUtil.addDate("HH", 12, Calendar.getInstance().getTime()))
	           .signWith(SignatureAlgorithm.HS512, salt)
	           .compact();
	   res.addHeader("Authorization", "Bearer " + token);
	   
	   String theData = "\"data\":{\"userName\":\""+userDetails.getUsername()+"\"}";
	   res.setContentType("application/json; charset=utf-8");
	   res.getWriter().write("{\"code\":\"0000\",\"msg\":\"登录成功\","+theData+"}");
   }
   
}
