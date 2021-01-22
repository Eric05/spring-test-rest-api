package com.hibernatetest.demo.presentation.controller;

import com.hibernatetest.demo.application.StudentService;
import com.hibernatetest.demo.persistence.model.Student;
import com.hibernatetest.demo.persistence.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public @ResponseBody
    Iterable<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public @ResponseBody
    Student getStudentById(@PathVariable("id") int id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/students")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteStudent(@PathVariable("id") int id){
        studentService.deleteStudent(id);
    }
}
