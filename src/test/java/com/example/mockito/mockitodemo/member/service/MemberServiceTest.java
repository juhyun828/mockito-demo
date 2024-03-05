package com.example.mockito.mockitodemo.member.service;


import com.example.mockito.mockitodemo.member.dto.MemberDto;
import com.example.mockito.mockitodemo.member.repository.MemberRepository;
import org.junit.Before;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.mockito.Mockito.when;

//@RunWith(PowerMockRunner.class)
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

//    @SpyBean
//    MemberRepository memberRepository;

    @Spy
    MemberService memberService;

    @Before
    public void setUp() throws Exception {
//        List<MemberDto> list1 = new ArrayList<>();
//        list1.add(new MemberDto("테스트이름", "서울시 테스트구", "테스트닉네임"));
//        when(memberService.retrieveMemberList()).thenReturn(list1);

        List<MemberDto> list2 = new ArrayList<>();
        list2.add(new MemberDto("테스트이름P", "서울시 테스트구", "테스트닉네임"));
        when(memberService.retrieveMemberListPrivate()).thenReturn(list2);
    }

    @Test
    public void retrieveMemberListPrivateTest() {
//        List<MemberDto> list = new ArrayList<>();
//        list.add(new MemberDto("테스트이름", "서울시 테스트구", "테스트닉네임"));
//        when(memberService.retrieveMemberList()).thenReturn(list);

        assert(memberService.retrieveMemberListPrivate().get(0).getName().contains("테스트이름P"));
    }

    @Test
    public void retrieveMemberListTest() {
//        List<MemberDto> list = new ArrayList<>();
//        list.add(new MemberDto("테스트이름C", "서울시 테스트구", "테스트닉네임"));
//        when(memberRepository.retrieveCMemberList()).thenReturn(list);
        List<MemberDto> list = memberService.retrieveMemberList();

        assert(list.get(0).getName().equals("테스트이름P"));
    }

//    @Test
//    public void retrieveMemberListPrivateTest() throws Exception {
//        List<MemberDto> list = new ArrayList<>();
//        list.add(new MemberDto("테스트이름P1", "서울시 테스트구", "테스트닉네임"));
//        list.add(new MemberDto("테스트이름P2", "서울시 테스트구", "테스트닉네임"));
//        PowerMockito.when(memberRepository, "retrieveMemberList", "").thenReturn(new Object());
//        assert(memberService.retrieveMemberList().get(0).getName().equals("테스트이름P1"));
//        assert(memberService.retrieveMemberList().get(1).getName().equals("테스트이름P2"));
//    }
}