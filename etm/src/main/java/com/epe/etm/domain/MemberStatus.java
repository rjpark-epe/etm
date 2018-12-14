package com.epe.etm.domain;

public enum MemberStatus{
	
	NORMAL("정상"),
	BLOCK("차단"),
	;
	
	private MemberStatus(String desc) {
		this.desc = desc;
	}
	
	private final String desc;

}
