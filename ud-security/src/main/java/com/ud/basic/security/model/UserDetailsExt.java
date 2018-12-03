package com.ud.basic.security.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserDetailsExt extends User implements UserDetails{
	
	private String orgId;
	
	public UserDetailsExt(String username, String password, Collection<? extends GrantedAuthority> authorities, String orgId) {
		super(username, password, authorities);
		this.orgId = orgId;
	}



}
