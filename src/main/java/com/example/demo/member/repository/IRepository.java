package com.example.demo.member.repository;

import java.util.List;
import java.util.Optional;

public interface IRepository<T, F> {
    T save(T entity);

    Optional<T> read(F id);

    List<T> readAll();

    T update(T entity, F id);

    void delete(F id);

}
