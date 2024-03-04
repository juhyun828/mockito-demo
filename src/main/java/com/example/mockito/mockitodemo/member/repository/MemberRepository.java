package com.example.mockito.mockitodemo.member.repository;

import com.example.mockito.mockitodemo.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MemberRepository {
    private List<MemberDto> retrieveMemberList() {
        List<MemberDto> memberDtoList = new ArrayList<>();
        memberDtoList.add(new MemberDto("kim", "인천시 연수구", "김"));
        memberDtoList.add(new MemberDto("choi", "서울시 강서구", "최"));
        memberDtoList.add(new MemberDto("lee", "서울시 마포구", "이"));
        return memberDtoList;
    }

    public List<MemberDto> retrieveCMemberList() {
        return this.retrieveMemberList();
    }
}
