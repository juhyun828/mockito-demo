package com.example.mockito.mockitodemo.member.service;

import com.example.mockito.mockitodemo.member.dto.MemberDto;
import com.example.mockito.mockitodemo.member.repository.MemberRepository;
import com.example.mockito.mockitodemo.team.dto.TeamDto;
import com.example.mockito.mockitodemo.team.service.TeamService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MemberService {
    private TeamService teamService;

    public List<MemberDto> retrieveMemberList() {
//        return memberRepository.retrieveCMemberList();
        return this.retrieveMemberListPrivate();
    }


    public List<MemberDto> retrieveMemberListPrivate() {
        List<MemberDto> memberDtoList = new ArrayList<>();
        memberDtoList.add(new MemberDto("kim", "인천시 연수구", "김"));
        memberDtoList.add(new MemberDto("choi", "서울시 강서구", "최"));
        memberDtoList.add(new MemberDto("lee", "서울시 마포구", "이"));
        return memberDtoList;
    }

    public List<TeamDto> retrieveTeam(MemberDto memberDto) {
        return teamService.retrieveTeam(memberDto);
    }
}
