package com.ud.basic.system.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ud.basic.system.biz.domain.SysResourceDomain;
import com.ud.basic.system.biz.domain.SysRoleDomain;
import com.ud.basic.system.biz.domain.SysUserDomain;
import com.ud.basic.system.biz.model.DO.SysUserDO;
import com.ud.basic.system.core.security.model.UserDetailsExt;
import com.ud.basic.system.persistence.sys.auto.model.SysRole;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceExt implements UserDetailsService {

    @Autowired
    SysUserDomain sysUserDomain;
    @Autowired
    SysResourceDomain sysMenuResourceDomain;
    @Autowired
    SysRoleDomain sysRoleDomain;
    
    public UserDetails loadUserByUsername(String username) {
    	SysUserDO user = sysUserDomain.getByUserName(username);
		if(user == null){
			throw new UsernameNotFoundException("用户不存在");
		}
		
        List<GrantedAuthority> grantedAuthorities = new ArrayList <>();
        SysRole role = sysRoleDomain.findById(Long.valueOf(user.getRoleId()));
        if(!StringUtils.isEmpty(role.getResourceRights())) {
        	GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getResourceRights());
        	grantedAuthorities.add(grantedAuthority);
        }
        
//        List<SysResource> permissions = sysMenuResourceDomain.getByRole(Long.valueOf(user.getRoleId()));
//        if(!CollectionUtils.isEmpty(permissions)) {
//        	for (SysResource permission : permissions) {
//                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(String.valueOf(permission.getId()));
//                //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
//                grantedAuthorities.add(grantedAuthority);
//            }
//        }
		UserDetailsExt result = new UserDetailsExt(user.getUsername(), user.getPassword(), grantedAuthorities, user.getOrgId().toString());
		return result; 
    }
    

}
