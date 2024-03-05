package com.example.mockito.mockitodemo.team.service;

import com.example.mockito.mockitodemo.member.dto.MemberDto;
import com.example.mockito.mockitodemo.team.dto.TeamDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class TeamService {
    public List<TeamDto> retrieveTeam(MemberDto memberDto) {
        List<TeamDto> list = new ArrayList<>();
        list.add(new TeamDto("team1", "서울시 강서구",
                new MemberDto("member1", "서울시 강서구", "닉네임")));
        list.add(new TeamDto("team2", "서울시 마포구",
                new MemberDto("member2", "서울시 강서구", "닉네임")));
        list.add(new TeamDto("team3", "인천시 남구",
                new MemberDto("member1", "서울시 서대문구", "닉네임")));

        list = list.stream().filter(v -> v.getMemberDto().getName().equals(memberDto.getName()))
                .toList();
        return list;
    }

}
