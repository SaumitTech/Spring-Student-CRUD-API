package com.example.StudentCRUDapi.service;

import com.example.StudentCRUDapi.entity.Student;
import com.example.StudentCRUDapi.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    //Inject Repo to get all the JPA methods
    @Autowired
    StudentRepository studentRepository;

    //add student
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    //get all students
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    //get student by ID
    public Optional findById(int id){
        Optional stu = studentRepository.findById(id);
        return stu;
    }

    //update student
    public Student updateStudent(int id, Student newStudent){
        //get Existing Student Obj
        Optional<Student> oldStudent = studentRepository.findById(id);

        //create a new student obj
        Student updatedStudent = oldStudent.get();

        //set the updated Data
        updatedStudent.setName(newStudent.getName());
        updatedStudent.setGrade(newStudent.getGrade());

        //save to repo
        return studentRepository.save(updatedStudent);
    }

    //delete student by ID
    public void deleteStudent(int id){
        studentRepository.deleteById(id);

//        return "Student deleted Successfully: " + id;
    }


}
