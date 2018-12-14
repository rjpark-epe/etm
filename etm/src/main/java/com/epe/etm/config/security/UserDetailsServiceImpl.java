package com.epe.etm.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.epe.etm.domain.MemberRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired private MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return Optional.ofNullable(memberRepository.findById(username))
		.filter(m -> m!= null)
		.map(m -> new SecurityMember(m.get())).get();
	}

}
