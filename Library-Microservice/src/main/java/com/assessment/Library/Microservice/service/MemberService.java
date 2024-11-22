package com.assessment.Library.Microservice.service;

import com.assessment.Library.Microservice.model.Member;
import com.assessment.Library.Microservice.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public Member addMember(Member member) {
        member.setMembershipDate(LocalDate.now());
        return memberRepository.save(member);
    }
}
