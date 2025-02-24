package com.example.demo.member.controller.dto;

import com.example.demo.member.repository.entity.Member;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;


@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class MemberCreateRequestDto {
    String name;
    Integer age;
    String email;
    String job;
    String specialty;

    public Member toEntity() {
        return new Member(null, name, age, email, job, specialty, LocalDateTime.now());
    }
}
