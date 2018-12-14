package com.epe.etm.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<MemberVo, String>{

	MemberVo findByMemberId(String memberId);
}
