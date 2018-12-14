package com.epe.etm.config.security;


import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.GrantedAuthority;


/** 
 * 이 외에 동적으로 생성되는 권한도 있을 수 있음
 * 모든 권한 체크는 "XX를 포함하는가" 를 OR 조건으로 결정됨
 * 즉 "XX를 포함하지 않을때" 같은 부정문 조건은 지양한다.
 * */
public enum RoleAttribute implements GrantedAuthority,ConfigAttribute{
	
	
	//=======================  기본 권한 =======================
    /** 아무 인증을 못받으면 기본으로 생성. 로그인 성공하면 삭제됨. */
	ROLE_ANONYMOUS,
    /** 로그인에 성공하면 무조건 생성 */
	ROLE_LOGIN,
    //=======================  유저 그룹별 권한 (RoleGroup과 1:1로 매핑된다.) =======================
	/** 개발자 */
    ROLE_USER_DEV,
    /** 관리자 */
    ROLE_USER_MGR,
    //=======================  기능별 제한 권한 =======================
    /** 개발자 */
    ROLE_DEV,
    /** 관리자 */
    ROLE_MGR,
    
    ;

	@Override
	public String getAttribute() {
		return this.name();
	}

	@Override
	public String getAuthority() {
		return this.name();
	}
	
	
}