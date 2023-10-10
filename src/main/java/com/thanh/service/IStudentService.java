package com.thanh.service;

import com.thanh.model.Student;

public interface IStudentService extends IGenerateService<Student>{
Iterable<Student> searchByName(String search);
}
