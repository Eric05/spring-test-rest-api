package com.hibernatetest.demo.presentation.controller;

import com.hibernatetest.demo.application.StudentService;
import com.hibernatetest.demo.persistence.model.Student;
import com.hibernatetest.demo.persistence.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

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
        studentService.saveStudent(student);
    }

    @PutMapping("/students/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
        try {
            studentService.updateStudent(student, id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteStudent(@PathVariable("id") int id){
        studentService.deleteStudent(id);
    }
}
