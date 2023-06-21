package com.student.springBootAPI.controller;
import com.student.springBootAPI.repository.StudentRepository;
import com.student.springBootAPI.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.student.springBootAPI.exception.StudentNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;


@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @RequestMapping("/students")
    private List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
    //find students by id
    @GetMapping(value = "/students/{id}")
    private Student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }
    // Exception handler for StudentNotFoundException
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFoundException(StudentNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @PostMapping(value = "/students/enroll")
    private ResponseEntity<?> addStudent(@RequestBody Student student) {
        Long id = student.getId();
        if (studentRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Student with ID " + id + " already exists.");
        }
        Student savedStudent = studentRepository.save(student);
        return ResponseEntity.ok(savedStudent);
    }

    @PutMapping(value="/students/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        if (!studentRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Student not found for ID: " + id);
        }

        student.setId(id); // Set the ID of the student to update

        Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping(value = "/students/delete/{id}")
    private ResponseEntity<HttpStatus> deleteStudent(@PathVariable Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return ResponseEntity.ok(HttpStatus.OK);
        } else {
            throw new StudentNotFoundException(id);
        }
    }


}

