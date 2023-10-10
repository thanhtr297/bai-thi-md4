package com.thanh.controller;

import com.thanh.service.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/classes")
public class ClassesController {
    @Autowired
    private IClassesService classesService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(classesService.findAll(), HttpStatus.OK);
    }

}
