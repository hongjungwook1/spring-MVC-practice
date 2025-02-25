package com.example.demo.member.repository;

import com.example.demo.member.repository.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Member save(Member entity);

    Optional<Member> findById(Integer id);

    List<Member> findAll();


}
