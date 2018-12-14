package com.epe.etm.config.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;

/** 
 * 아무것도 안하는 사용자 체커.
 * 비밀번호 만기 등의 로직에서, 즉시 예외를 던지지 말고 마킹만 해야하는 경우가 있음. 
 *  */
public class NontUserDetailChecker implements UserDetailsChecker{

	@Override
	public void check(UserDetails user) {
		//진짜로 아무것도 안한다!!
	}
    

	
}
