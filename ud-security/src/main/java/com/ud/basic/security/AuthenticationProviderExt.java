package com.ud.basic.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.ud.basic.security.model.UserDetailsExt;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthenticationProviderExt implements AuthenticationProvider {
	
	@Autowired
    private UserDetailsServiceExt myUserDetailsService;
    
    
    /**
     * 自定义验证方式
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        UserDetailsExt user = (UserDetailsExt) myUserDetailsService.loadUserByUsername(username);
        if(user == null){
            throw new BadCredentialsException("Username not found.");
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		PasswordEncoder passwordEncoder =  new PasswordEncoder() {
			@Override
			public String encode(CharSequence rawPassword) {
				return bCryptPasswordEncoder.encode(rawPassword);
			}

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
			}
		};
		if (!passwordEncoder.matches(password, user.getPassword())) { //!passwordEncoder.isPasswordValid(user.getPassword(),password, null)
			log.debug("Authentication failed: password does not match stored value");
			passwordEncoder.matches("", password);
			throw new BadCredentialsException("Wrong password.");
		}

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
//        createSuccessAuthentication(principalToReturn, authentication, user)
        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }

}