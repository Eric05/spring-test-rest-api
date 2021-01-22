package com.hibernatetest.demo.persistence.repository;

import com.hibernatetest.demo.persistence.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
