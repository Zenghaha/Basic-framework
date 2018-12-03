package com.ud.basic.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;

import com.ud.basic.security.handler.AccessDeniedHandlerExt;
import com.ud.basic.security.handler.AuthenticationSuccessHandlerExt;
import com.ud.basic.security.handler.LogoutSuccessHandlerExt;
import com.ud.basic.security.jwt.JwtAuthenticationFilter;
import com.ud.basic.security.jwt.JwtLoginFilter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceExt userService;
	@Autowired
    private AuthenticationProviderExt myAuthenticationProvider;
	@Autowired
	private AuthenticationSuccessHandlerExt myAuthenticationSuccessHandler;
	@Autowired
	private LogoutSuccessHandlerExt myLogoutSuccessHandler;
	@Autowired
	private AccessDeniedHandlerExt apiAccessDeniedHandler;
	@Value("${jwt.token.salt}")
	private String salt;
	@Value("${ud.basic.system.security.permit.matchers}")
	private String permitMatchers;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	List<String> matchers = new ArrayList<>(
    			Arrays.asList("/swagger-ui.html"
	    			, "/webjars/**"
	    			, "/v2/**"
	    			, "/swagger-resources/**"
	    			, "/code.do"
	    			, "/file/**"));
    	if(!StringUtils.isEmpty(permitMatchers)) {
    		String[] matcherExt = permitMatchers.split(",");
    		List<String> matcherExtList = Arrays.asList(matcherExt);
    		matchers.addAll(matcherExtList);
    	}
        http.authorizeRequests()
    		.antMatchers(matchers.toArray(new String[matchers.size()])).permitAll()
            .anyRequest().authenticated()
            .and().formLogin()
            .loginProcessingUrl("/login")
            .successHandler(myAuthenticationSuccessHandler).permitAll()
//            .failureHandler(myAuthenticationFailureHandler).permitAll()
            //jwt
            .and().addFilter(new JwtLoginFilter(authenticationManager(), userService,salt))
            .addFilter(new JwtAuthenticationFilter(authenticationManager(), userService,salt))
            
            .logout().invalidateHttpSession(true).logoutSuccessHandler(myLogoutSuccessHandler).permitAll()
            .and().exceptionHandling().authenticationEntryPoint(new LoginUrlAuthenticationEntryPointExt("/tologin"))
            .and().exceptionHandling().accessDeniedHandler(apiAccessDeniedHandler)
            
            .and().csrf().disable();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //将验证过程交给自定义验证工具
        auth.authenticationProvider(myAuthenticationProvider);
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder()); //user Details Service验证
    }
    
    @Override
	protected AuthenticationManager authenticationManager() throws Exception {
		ProviderManager authenticationManager = new ProviderManager(Arrays.asList(myAuthenticationProvider));
		//不擦除认证密码，擦除会导致TokenBasedRememberMeServices因为找不到Credentials再调用UserDetailsService而抛出UsernameNotFoundException
		authenticationManager.setEraseCredentialsAfterAuthentication(false);
		return authenticationManager;
	}
    
}
