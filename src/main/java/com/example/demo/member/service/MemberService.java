package com.example.demo.member.service;

import com.example.demo.member.controller.dto.MemberCreateRequestDto;
import com.example.demo.member.controller.dto.MemberResponseDto;
import com.example.demo.member.exception.CustomException;
import com.example.demo.member.exception.ExceptionType;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.member.repository.entity.Member;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
public class MemberService {

    MemberRepository memberRepository;

    @Transactional
    public MemberResponseDto create(MemberCreateRequestDto dto) {
        log.info("회원 생성 요청 : {}", dto);

        Member newMember = dto.toEntity();
        Member savedMember = memberRepository.save(newMember);

        log.info("회원 생성 완료 : {}", savedMember);
        return MemberResponseDto.from(savedMember);
    }

    @Transactional
    public MemberResponseDto read(Integer id) {
        Member readMember = memberRepository.findById(id)
                .orElseThrow(() -> new CustomException(ExceptionType.USER_NOT_FOUND, "유저를 찾을 수 없습니다. id :" + id));
        return MemberResponseDto.from(readMember);
    }

    @Transactional
    public List<MemberResponseDto> readAll() {
        List<Member> readAllMember = memberRepository.findAll();
        return readAllMember.stream().map((each) -> MemberResponseDto.from(each)).toList();
    }
//
//    public MemberResponseDto update(MemberCreateRequestDto dto, Integer id) {
//        Member updateMember = memberRepository.update(dto.toEntity(), id);
//        return MemberResponseDto.from(updateMember);
//    }
//
//    public void delete(Integer id) {
//        memberRepository.delete(id);
//    }
}
