package uz.ksan.backend.student.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import uz.ksan.backend.student.model.Student;
import uz.ksan.backend.student.repository.StudentRepository;
import uz.ksan.backend.student.service.StudentService;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
@Transactional
public class StudentImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findStudentsBySchool(Long schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }

}
