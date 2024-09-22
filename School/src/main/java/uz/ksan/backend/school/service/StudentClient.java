package uz.ksan.backend.school.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uz.ksan.backend.school.model.Student;

import java.util.List;


@FeignClient(name = "student-service", url = "${application.config.studentsUrl}")
public interface StudentClient {

    @GetMapping("/school/{schoolId}")
    List<Student> findAllStudentsBySchool(@PathVariable("schoolId") Long schoolId);

}
