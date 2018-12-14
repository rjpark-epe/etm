package com.epe.etm.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import com.google.common.base.Strings;

public class AdminLoginProvider extends AbstractUserDetailsAdminProvider{

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		
		String pass = authentication.getCredentials().toString();
		
		if(Strings.isNullOrEmpty(pass)) throw new BadCredentialsException("pass is required");
		
		AuthenticationDetails detail = (AuthenticationDetails) authentication.getDetails(); //WebAuthenticationDetails 
		String ip = detail.getIp(); 
		
		if(!(ip.startsWith("49.254.179.") || ip.startsWith("49.254.179."))) throw new BadCredentialsException("ip m​ismatch");
		
		detail.setProvider(this.getClass().getSimpleName());
		
		log.debug("관리자 {}님이  IP({})로 로그인됩니다.",userDetails.getUsername(),ip);
	}
}
