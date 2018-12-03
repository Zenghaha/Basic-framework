package com.ud.basic.common.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginUtil {

//	private static final String DELIMITER = ":";
	
	public static String getLoginName() {
		String userName = null;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String token = request.getHeader("Authorization");
//		String[] tokens = LoginUtil.decodeToken(token);
//		if(null != tokens && tokens.length == 4) {
//			userName = tokens[0];
//		}
		List<Object> tokens = LoginUtil.decodeToken(token);
		if(!CollectionUtils.isEmpty(tokens)) {
			userName = tokens.get(0).toString();
		}
		return userName;
	}
	
	public static String getLoginOwner() {
		String owner = null;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String token = request.getHeader("Authorization");
//		String[] tokens = LoginUtil.decodeToken(token);
//		if(null != tokens && tokens.length == 4) {
//			owner = tokens[3];
//		}
		List<Object> tokens = LoginUtil.decodeToken(token);
		if(!CollectionUtils.isEmpty(tokens)) {
			owner = tokens.get(1).toString();
		}
		
		return owner;
	}
	
	public static List<Object> decodeToken(String token){
		JSONArray array = null;
		String sub = null;
		try {
			sub = Jwts.parser()
		           .setSigningKey(PropertiesUtil.getPropertiesKey("jwt.token.salt"))
		   .parseClaimsJws(token.replace("Bearer ", ""))
		   .getBody()
		   .getSubject();
		} catch (Exception e) {
			log.info("无效token");
		}
		if(!StringUtils.isEmpty(sub)) {
			array = JSON.parseArray(sub);
		}
		return array;
	}
//	private static String[] decodeToken(String cookieValue)  {
//		String[] tokens = null;
//		for (int j = 0; j < cookieValue.length() % 4; j++) {
//			cookieValue = cookieValue + "=";
//		}
//
//		if (!Base64.isBase64(cookieValue.getBytes())) {
//			throw new InvalidCookieException(
//					"Cookie token was not Base64 encoded; value was '"
//							+ cookieValue + "'");
//		}
//
//		String cookieAsPlainText = new String(Base64.decode(cookieValue
//				.getBytes()));
//
//		tokens = StringUtils.delimitedListToStringArray(
//				cookieAsPlainText, DELIMITER);
//
//		if ((tokens[0].equalsIgnoreCase("http") || tokens[0]
//				.equalsIgnoreCase("https")) && tokens[1].startsWith("//")) {
//			// Assume we've accidentally split a URL (OpenID identifier)
//			String[] newTokens = new String[tokens.length - 1];
//			newTokens[0] = tokens[0] + ":" + tokens[1];
//			System.arraycopy(tokens, 2, newTokens, 1, newTokens.length - 1);
//			tokens = newTokens;
//		}
//
//		return tokens;
//	}
}
