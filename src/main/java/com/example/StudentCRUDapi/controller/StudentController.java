package com.example.StudentCRUDapi.controller;

import com.example.StudentCRUDapi.entity.Student;
import com.example.StudentCRUDapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    //Inject Service to get all methods
    @Autowired
    StudentService studentService;

    //add student
    @PostMapping("/student")
    private Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    //get all students
    @GetMapping("/student")
    private List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    //get student by ID
    @GetMapping("/student/{id}")
    private Optional findById(@PathVariable int id){
        return studentService.findById(id);
    }

    //update student
    @PutMapping("/student/{id}")
    private Student updateStudent(@PathVariable int id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

    //delete student by ID
    @DeleteMapping("/student/{id}")
    private String deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return "Student deleted Successfully: " + id;
    }

}
