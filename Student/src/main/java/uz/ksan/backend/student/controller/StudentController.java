package uz.ksan.backend.student.controller;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ksan.backend.student.model.Student;
import uz.ksan.backend.student.service.StudentService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Transactional
    @RequestMapping("/api/v1/students")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents() {
        return ResponseEntity.ok(studentService.findAllStudents());
    }

    @GetMapping("school/{schoolId}")
    public ResponseEntity<List<Student>> findAllStudentsBySchoolId(@PathVariable Long schoolId) {
        return ResponseEntity.ok(studentService.findStudentsBySchool(schoolId));
    }

}
