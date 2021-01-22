package com.hibernatetest.demo.application;

import com.hibernatetest.demo.persistence.model.Student;
import com.hibernatetest.demo.persistence.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(int id){
        studentRepository.deleteById(id);
    }
}
