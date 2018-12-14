package com.epe.etm.config.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.epe.etm.domain.MemberVo;

@SuppressWarnings("serial")
public class SecurityMember extends User {

	public SecurityMember(MemberVo member) {
		super(member.getMemberId(), member.getPwd(), makeGrantedAuthority(member.getRoleGroup()));
	}

	private static List<GrantedAuthority> makeGrantedAuthority(RoleGroup roleGroup) {
		List<GrantedAuthority> list = new ArrayList<>();
		roleGroup.defaultRoles.forEach(role -> list.add(new SimpleGrantedAuthority(role.getAuthority())));
		return list;
	}

}
