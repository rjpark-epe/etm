package com.epe.etm.config.security;

import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.NullAuthoritiesMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;

import lombok.Data;

/**
 * AbstractUserDetailsAuthenticationProvider의 경우 인증이 실패한다면 반드시 예외를 던져야 한다.
 *  => 나는 인증 실패시 원래의 인증로직을 타게 하고싶어서 AbstractUserDetailsAuthenticationProvider 를 상속하지않고 하나 더 만들었다.
 *  
 * 원래 프로바이더 앞에 와야 한다.  비번 정합 여부와 상관없이 강제 로그인을 하기 위한 로직이다.
 * 경고! 야매성 로직임으로 IP등, 반드시 강력한 수단을 통해서 인증해야 한다. 
 * */
@Data
public abstract class AbstractUserDetailsAdminProvider implements AuthenticationProvider{

	private UserDetailsService userDetailsService;
	private GrantedAuthoritiesMapper authoritiesMapper = new NullAuthoritiesMapper();
	private UserDetailsChecker preAuthenticationChecks = new NontUserDetailChecker();
    private UserDetailsChecker postAuthenticationChecks = new NontUserDetailChecker();
	
	/**
	 * 예외를 잡아서 null을 리턴한다. (즉 다음 프로바이더로 작업을 넘긴다.) 
	 *  */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		try {
			UserDetails user = userDetailsService.loadUserByUsername(authentication.getName());
			//전처리. 계정에 문제가 있는지 판단.
			preAuthenticationChecks.check(user);
			//ID와 패스워드를 매칭
			additionalAuthenticationChecks(user, (UsernamePasswordAuthenticationToken)authentication);
			//부가정보를 로드해 준다.
			postAuthenticationChecks.check(user);
			
			UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(user, authentication.getCredentials(), authoritiesMapper.mapAuthorities(user.getAuthorities()));
	        result.setDetails(authentication.getDetails());
			return result;
			
		} catch (AccountStatusException e) {
			//계정 상태 예외는 걍 던진다.
			throw e;
		} catch (AuthenticationException e) {
			//일반 인증 예외는 무시한다.
			return null;
		}
	}
	
	protected abstract void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException;
	
	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}


    
    
	
}
