package uz.ksan.backend.school.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import uz.ksan.backend.school.service.StudentClient;
import uz.ksan.backend.school.model.FullSchoolResponse;
import uz.ksan.backend.school.model.School;
import uz.ksan.backend.school.repository.SchoolRepository;
import uz.ksan.backend.school.service.SchoolService;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
@Transactional
public class SchoolImpl implements SchoolService {
    private final SchoolRepository schoolRepository;
    private final StudentClient client;

    @Override
    public void saveSchool(School school) {
        schoolRepository.save(school);
    }

    @Override
    public List<School> findAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public FullSchoolResponse findAllSchoolsWithStudents(Long schoolId) {
        var school = schoolRepository.findById(schoolId)
                .orElse(School.builder()            //handle 0 pointer exception
                        .id(0L)
                        .name("NOT_FOUND")
                        .address("NOT_FOUND")
                        .email("NOT_FOUND")
                        .build());
        var students = client.findAllStudentsBySchool(schoolId);            //find all the students from the student micro-service
        return FullSchoolResponse.builder()
                .address(school.getAddress())
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
