package com.ud.basic.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ud.basic.security.domain.LoginDomain;
import com.ud.basic.security.model.LoginUserDO;
import com.ud.basic.security.model.UserDetailsExt;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceExt implements UserDetailsService {

    @Autowired
    LoginDomain loginUserDomain;
    
    public UserDetails loadUserByUsername(String username) {
    	LoginUserDO user = loginUserDomain.getByUserName(username);
		if(user == null){
			throw new UsernameNotFoundException("用户不存在");
		}
        List<GrantedAuthority> grantedAuthorities = new ArrayList <>();
		UserDetailsExt result = new UserDetailsExt(user.getUsername(), user.getPassword(), grantedAuthorities, user.getOrgId().toString());
		return result; 
    }
    

}
