package com.student.springBootAPI.repository;

import com.student.springBootAPI.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
