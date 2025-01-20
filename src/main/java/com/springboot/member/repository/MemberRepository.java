package com.springboot.member.repository;

import com.springboot.member.entity.Member;
import com.springboot.member.entity.MemberExcludeName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> { // 수정된 부분
    Optional<Member> findByEmail(String email);
    Optional<MemberExcludeName> findByMemberId(long memberId); // Member 대신에 MemberExcludeName을 리턴한다. 쿼리 확인
}
