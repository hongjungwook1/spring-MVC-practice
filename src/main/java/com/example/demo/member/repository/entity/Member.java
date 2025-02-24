package com.example.demo.member.repository.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class Member {
    @Setter
    Integer id;
    String name;
    Integer age;
    String email;
    String job;
    String specialty;
}
