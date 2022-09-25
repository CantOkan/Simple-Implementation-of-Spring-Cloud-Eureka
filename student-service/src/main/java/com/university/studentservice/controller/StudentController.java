package com.university.studentservice.controller;


import com.university.studentservice.dto.StudentRequest;
import com.university.studentservice.dto.StudentResponse;
import com.university.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public StudentResponse createStudent(@RequestBody StudentRequest studentRequest){
        return studentService.createStudent(studentRequest);
    }

    @GetMapping("/getById/{id}")
    public StudentResponse getById(@PathVariable Integer id){
        return studentService.getById(id);
    }
}
