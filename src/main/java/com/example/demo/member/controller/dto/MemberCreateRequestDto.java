package com.example.demo.member.controller.dto;

import com.example.demo.member.repository.entity.Member;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;


@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class MemberCreateRequestDto {
    @JsonProperty("member_name")
    String name;
    @JsonProperty("member_age")
    Integer age;
    @JsonProperty("member_email")
    String email;
    @JsonProperty("member_job")
    String job;
    @JsonProperty("member_specialty")
    String specialty;

    public Member toEntity() {
        return new Member(null, name, age, email, job, specialty, LocalDateTime.now());
    }
}
