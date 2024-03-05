package com.example.mockito.mockitodemo.member.service;


import com.example.mockito.mockitodemo.member.dto.MemberDto;
import com.example.mockito.mockitodemo.team.dto.TeamDto;
import com.example.mockito.mockitodemo.team.service.TeamService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

//@RunWith(PowerMockRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberServiceTestByGuide {
    @Autowired
    MemberService memberService;

    @SpyBean
    TeamService teamServiceSpy;

    @Test
    public void retrieveTeamTest() {
        /* given */
        MemberDto memberDto  = new MemberDto("testMember1", "서울시 은평구", "닉네임");
        List<TeamDto> list = new ArrayList<>();
        list.add(new TeamDto("testteam1", "서울시 테스터구", new MemberDto("t","t","t")));
        list.add(new TeamDto("testteam2", "서울시 테스터구", new MemberDto("testMember1", "서울시 은평구", "닉네임")));
        Mockito.doReturn(list).when(teamServiceSpy).retrieveTeam(memberDto);

        /* when */
        List<TeamDto> result = memberService.retrieveTeam(memberDto);
        result.stream().forEach(v -> System.out.printf(v.toString()));

        /* then */
        assert(result.get(0).getTeamName().equals("testteam2"));
        assert(result.get(0).getMemberDto().getName().equals("testMember1"));
        assertFalse(result.get(0).getTeamName().equals("team1"));
    }
}