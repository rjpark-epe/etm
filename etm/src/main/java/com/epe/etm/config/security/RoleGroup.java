package com.epe.etm.config.security;


import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import com.google.common.collect.ImmutableSet;


/** 계정과 1:1로 매칭하기 위해 만들어진 그룹
 * 기본 권한들이 주어진다
 *  */
public enum RoleGroup {
	
    /** 개발자 */
    USER_DEV("개발자", RoleAttribute.ROLE_USER_DEV, RoleAttribute.ROLE_DEV),
    /** 관리자 */
    USER_MGR("관리자", RoleAttribute.ROLE_USER_MGR, RoleAttribute.ROLE_MGR),
    ;
    
    public final String groupName;
    public final Set<GrantedAuthority> defaultRoles;
    public final String desc;
    
    private  RoleGroup(String groupName, GrantedAuthority ... defaultRoles){
        this.groupName = groupName;
        this.defaultRoles = ImmutableSet.copyOf(defaultRoles);
        this.desc = groupName;
    }
    
}
