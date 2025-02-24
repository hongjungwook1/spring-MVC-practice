package com.example.demo.member.service;

import com.example.demo.member.controller.dto.MemberCreateRequestDto;
import com.example.demo.member.controller.dto.MemberResponseDto;
import com.example.demo.member.exception.CustomException;
import com.example.demo.member.exception.ExceptionType;
import com.example.demo.member.repository.IRepository;
import com.example.demo.member.repository.entity.Member;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
public class MemberService {

    IRepository<Member, Integer> memberRepository;

    public MemberResponseDto create(MemberCreateRequestDto dto) {
        Member createMember = memberRepository.save(dto.toEntity());
        return MemberResponseDto.from(createMember);
    }

    public MemberResponseDto read(Integer id) {
        Member readMember = memberRepository.read(id)
                .orElseThrow(() -> new CustomException(ExceptionType.USER_NOT_FOUND, "유저를 찾을 수 없습니다. id :" + id));
        return MemberResponseDto.from(readMember);
    }

    public List<MemberResponseDto> readAll() {
        List<Member> readAllMember = memberRepository.readAll();
        return readAllMember.stream().map((each) -> MemberResponseDto.from(each)).toList();
    }

    public MemberResponseDto update(MemberCreateRequestDto dto, Integer id) {
        Member updateMember = memberRepository.update(dto.toEntity(), id);
        return MemberResponseDto.from(updateMember);
    }

    public void delete(Integer id) {
        memberRepository.delete(id);
    }
}
