package com.example.mockito.mockitodemo.team.dto;

import com.example.mockito.mockitodemo.member.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeamDto {
    String teamName;
    String teamAddress;
    MemberDto memberDto;
}
