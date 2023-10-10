package com.thanh.controller;

import com.thanh.model.Student;
import com.thanh.service.IStudentService;
import com.thanh.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping
    public ResponseEntity<?> showStudent(){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id){
        Optional<Student> student = studentService.findOne(id);
        if (student.isPresent()){
            return new ResponseEntity<>(student,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Student student){
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/search/{search}")
    public ResponseEntity<?> searchByName(@PathVariable String search){
        return new ResponseEntity<>(studentService.searchByName(search),HttpStatus.OK);
    }
}
