package com.example.demo.member.controller.dto;

import com.example.demo.member.repository.entity.Member;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public class MemberResponseDto {
    Integer id;
    String name;
    Integer age;
    String email;
    String job;
    String specialty;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy년 MM월dd일 HH시mm분", timezone = "Asia/Seoul")
    LocalDateTime createAt;

    public static MemberResponseDto from(Member member) {
        return new MemberResponseDto(
                member.getId(),
                member.getName(),
                member.getAge(),
                member.getEmail(),
                member.getJob(),
                member.getSpecialty(),
                member.getCreateAt()
        );
    }
}
