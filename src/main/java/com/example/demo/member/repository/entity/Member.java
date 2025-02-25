package com.example.demo.member.repository.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    @Setter
    Integer id;
    @Column(name = "member_name")
    String name;
    @Column(name = "member_age")
    Integer age;
    @Column(name = "member_email")
    String email;
    @Column(name = "member_job")
    String job;
    @Column(name = "member_specialty")
    String specialty;
    @Column(name = "member_createAt")
    LocalDateTime createAt;

}
