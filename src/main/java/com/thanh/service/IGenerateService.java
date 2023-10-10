package com.thanh.service;

import java.util.Optional;

public interface IGenerateService<E> {
    Iterable<E> findAll();
    Optional<E> findOne(Long id);
    void save(E e);
    void delete(Long id);
}
