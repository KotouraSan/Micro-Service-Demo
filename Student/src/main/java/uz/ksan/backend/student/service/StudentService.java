package uz.ksan.backend.student.service;

import uz.ksan.backend.student.model.Student;

import java.util.List;

public interface StudentService {
    void saveStudent(Student student);

    List<Student> findAllStudents();

    List<Student> findStudentsBySchool(Long schoolId);

}
