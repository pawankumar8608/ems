package com.ems.admin.authentication;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.ems.admin.service.AdminService;
import com.ems.admin.service.UserService;
import com.ems.persistence.domain.AdminRole;
import com.ems.persistence.domain.Administrator;
import com.ems.persistence.domain.User;

public class EmsAdminAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	@Qualifier("passwordEncoder")
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	public EmsAdminAuthenticationProvider(AdminService adminService, UserService userService){
		 this.adminService = adminService;
		 this.userService = userService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		   
		   UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		   String userName = token.getName();
		   String password = (String) token.getCredentials();
		   Administrator admin = null;
		   User user = null;
		   if(null != userName){
			    admin = adminService.authenticate(userName, password);
			    if(null != admin){
				   Collection<? extends GrantedAuthority> authorities = getAuthorities(admin);
				   return new UsernamePasswordAuthenticationToken(admin, password, authorities);
			    }else{
				   user =userService.authenticate(userName, password);
				   if(null != user){
					   Collection<? extends GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER");
					   return new UsernamePasswordAuthenticationToken(user, password, authorities);
				   }
			    }
		   }
		   throw new UsernameNotFoundException("Invalid Username/password");
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(Administrator admin){
		    Collection<AdminRole> roles = admin.getAdminRoles();
		    for(AdminRole role : roles){
		    	String s = role.getRole();
		    	if(s.startsWith("admin")){
		    		return AuthorityUtils.createAuthorityList("ROLE_ADMIN");
		    	}
		    }
		           return AuthorityUtils.NO_AUTHORITIES;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}
	
	public void setEncoder(BCryptPasswordEncoder encoder) {
		this.encoder = encoder;
	}

}
