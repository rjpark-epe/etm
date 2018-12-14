package com.epe.etm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.epe.etm.config.security.RoleGroup;
import com.epe.etm.domain.standard.Metadata;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Table(name = "MEMBER")
@Data
@EqualsAndHashCode(of = "memberId",callSuper=false)
public class MemberVo extends Metadata{

	
	@GeneratedValue
	@Id
	private String memberId;

	@NotNull
	private String pwd;

	@Enumerated(EnumType.STRING)
	@Column(length = 50)
	@NotNull
	private MemberStatus memberStatus;

	@Enumerated(EnumType.STRING)
	@Column(length = 50)
	@NotNull
	private RoleGroup roleGroup;
	
	private String hp;

	private String email;

	private String ip;


}
