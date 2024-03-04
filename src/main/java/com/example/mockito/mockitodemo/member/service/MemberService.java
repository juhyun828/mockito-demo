package com.example.mockito.mockitodemo.member.service;

import com.example.mockito.mockitodemo.member.dto.MemberDto;
import com.example.mockito.mockitodemo.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public List<MemberDto> retrieveMemberList() {
        return memberRepository.retrieveCMemberList();
    }

    public List<MemberDto> retrieveMemberListPrivate() {
        List<MemberDto> memberDtoList = new ArrayList<>();
        memberDtoList.add(new MemberDto("kim", "인천시 연수구", "김"));
        memberDtoList.add(new MemberDto("choi", "서울시 강서구", "최"));
        memberDtoList.add(new MemberDto("lee", "서울시 마포구", "이"));
        return memberDtoList;
    }
}
