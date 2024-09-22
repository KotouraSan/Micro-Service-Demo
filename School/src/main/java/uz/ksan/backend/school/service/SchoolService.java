package uz.ksan.backend.school.service;

import uz.ksan.backend.school.model.FullSchoolResponse;
import uz.ksan.backend.school.model.School;

import java.util.List;

public interface SchoolService {

    void saveSchool(School school);

    List<School> findAllSchools();

    FullSchoolResponse findAllSchoolsWithStudents(Long schoolId);
}
