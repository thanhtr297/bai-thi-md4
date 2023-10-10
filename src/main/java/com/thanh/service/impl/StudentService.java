package com.thanh.service.impl;

import com.thanh.model.Student;
import com.thanh.repository.StudentRepository;
import com.thanh.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StudentService implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findOne(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
    studentRepository.deleteById(id);
    }

    @Override
    public Iterable<Student> searchByName(String search) {
        return studentRepository.findAllByNameContaining(search);
    }
}
