package com.epe.etm.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epe.etm.domain.MemberRepository;

@RestController
public class LoginController {
	
	private final static Logger logger = LoggerFactory.getLogger(LoginController.class); 
	
	@Autowired private ApplicationContext ctx;
	@Autowired private MemberRepository memberRepository;

	@RequestMapping("/login")
	public String login() {
		return "로긴  페이지";
	}
	
}
