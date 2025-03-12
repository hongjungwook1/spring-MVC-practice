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
        Member newMember = dto.toEntity();
        Member savedMember = memberRepository.save(newMember);

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
        return readAllMember.stream().map(MemberResponseDto::from).toList();
    }

    @Transactional
    public MemberResponseDto update(MemberCreateRequestDto dto, Integer id) {
        Member existingMember = memberRepository.findById(id)
                .orElseThrow(() -> new CustomException(ExceptionType.USER_NOT_FOUND, "유저를 찾을 수 없습니다. id :" + id));

        Member updatedMember = existingMember.updatedMember(
                dto.toEntity().getName(),
                dto.toEntity().getAge(),
                dto.toEntity().getEmail(),
                dto.toEntity().getJob(),
                dto.toEntity().getSpecialty()
        );
        Member savedMember = memberRepository.save(updatedMember);
        return MemberResponseDto.from(savedMember);
    }

    @Transactional
    public void delete(Integer id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new CustomException(ExceptionType.USER_NOT_FOUND, "유저를 찾을 수 없습니다. id :" + id));
        memberRepository.delete(member);
    }
}
