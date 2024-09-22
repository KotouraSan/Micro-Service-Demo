package uz.ksan.backend.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ksan.backend.student.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllBySchoolId(Long schoolId);

}
