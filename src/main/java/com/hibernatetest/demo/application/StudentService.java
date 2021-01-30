package com.hibernatetest.demo.application;

import com.hibernatetest.demo.persistence.model.Student;
import com.hibernatetest.demo.persistence.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;
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

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    public void updateStudent(Student studentToUpdate, int id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isEmpty()) {
            throw new NoSuchElementException();
        }
        var student = optionalStudent.get();

        if (!Objects.isNull(studentToUpdate.getFirstname())) {
            student.setFirstname(studentToUpdate.getFirstname());
        }
        if (!Objects.isNull(studentToUpdate.getLastname())) {
            student.setLastname(studentToUpdate.getLastname());
        }
        saveStudent(student);
    }
}
