package com.epe.etm.domain.standard;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@MappedSuperclass
public class Metadata implements Serializable,Comparable<Metadata>{

	@Version
	@Setter
	@Getter
	private Date updateTime;
	@Setter
	@Getter
	private String updateId;
	@Setter
	@Getter
	private String updateIp;
	@Override
	public int compareTo(Metadata o) {
		return updateTime.compareTo(o.updateTime) * -1;
	}
	
}
