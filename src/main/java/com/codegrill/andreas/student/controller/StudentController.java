package com.codegrill.andreas.student.controller;

import com.codegrill.andreas.student.service.StudentService;
import com.codegrill.andreas.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){

        return studentService.getStudents();
    }

    @PostMapping()
    public void registerNewStudent(@RequestBody Student student){

        studentService.registerNewStudent(student);
    }

    @DeleteMapping(path="{id}")
    public void deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
    }

    @PutMapping(path="{id}")
    public void updateStudent(@PathVariable("id") Long id, @RequestParam(required = false) String name, @RequestParam(required = false) String email){
        studentService.updateStudent(id, name, email);
    }
}
