package com.student.springBootAPI.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(Long id) {
        super("Could not find student for this id: " + id);
    }
}
