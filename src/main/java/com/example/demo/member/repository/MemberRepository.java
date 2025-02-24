package com.example.demo.member.repository;

import com.example.demo.member.repository.entity.Member;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Repository
public class MemberRepository implements IRepository<Member, Integer> {
    private static Map<Integer, Member> members;

    static {
        members = new HashMap<>();
        members.put(1, new Member(1, "hong", 10, "hong@naver.com", "Developer", "Backend", LocalDateTime.now()));
        members.put(2, new Member(2, "kim", 20, "kim@naver.com", "Developer", "Frontend", LocalDateTime.now()));
        members.put(3, new Member(3, "lee", 30, "lee@naver.com", "Engineer", "DevOps", LocalDateTime.now()));
    }

    private static int idCount = 3;

    private int idGenerator() {
        return ++idCount;
    }

    @Override
    public Member save(Member entity) {
        int createId = idGenerator();
        entity.setId(createId);
        members.put(createId, entity);
        return entity;
    }

    @Override
    public Optional<Member> read(Integer id) {
        return Optional.ofNullable(members.get(id));
    }

    @Override
    public List<Member> readAll() {
        return new ArrayList<>(members.values());
    }

    @Override
    public Member update(Member entity, Integer id) {
        int getId = members.get(id).getId();
        entity.setId(getId);
        members.replace(getId, entity);
        return entity;
    }

    @Override
    public void delete(Integer id) {
        members.remove(id);
    }
}
