package com.thanh.service.impl;

import com.thanh.model.Classes;
import com.thanh.repository.ClassesRepository;
import com.thanh.service.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ClassesService implements IClassesService {
    @Autowired
    private ClassesRepository classesRepository;
    @Override
    public Iterable<Classes> findAll() {
        return classesRepository.findAll();
    }

    @Override
    public Optional<Classes> findOne(Long id) {
        return classesRepository.findById(id);
    }

    @Override
    public void save(Classes classes) {

    }

    @Override
    public void delete(Long id) {

    }
}
