package com.ud.basic.security.jwt;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

/**
* token的校验
* 该类继承自BasicAuthenticationFilter，在doFilterInternal方法中，
* 从http头的Authorization 项读取token数据，然后用Jwts包提供的方法校验token的合法性。
* 如果校验通过，就认为这是一个取得授权的合法请求
*/
@Slf4j
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

	UserDetailsService userDetailsService;
	
	String salt;
	
   public JwtAuthenticationFilter(AuthenticationManager authenticationManager, UserDetailsService userDetailsService,String salt) {
       super(authenticationManager);
       this.userDetailsService = userDetailsService;
       this.salt = salt;
   }

   @Override
   protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
       String header = request.getHeader("Authorization");

//       if (header == null || !header.startsWith("Bearer ")) {
//           chain.doFilter(request, response);
//           return;
//       }

       UsernamePasswordAuthenticationToken authentication = getAuthentication(request);

       SecurityContextHolder.getContext().setAuthentication(authentication);
       chain.doFilter(request, response);

   }

   private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
       String token = request.getHeader("Authorization");
       if (token != null) {
           // parse the token.
    	   String principal = null;
			try {
				principal = Jwts.parser()
			           .setSigningKey(salt)
			   .parseClaimsJws(token.replace("Bearer ", ""))
			   .getBody()
			   .getSubject();
			} catch (Exception e) {
				log.info("无效token");
			}
	           
	
	       if (principal != null) {
	    	   String username = JSON.parseArray(principal).getString(0);
	    	   UserDetails user = userDetailsService.loadUserByUsername(username);
	           return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
	       }
	       return null;
       }
       return null;
   }
}
