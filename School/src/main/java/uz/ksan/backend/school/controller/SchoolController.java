package uz.ksan.backend.school.controller;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ksan.backend.school.model.FullSchoolResponse;
import uz.ksan.backend.school.model.School;
import uz.ksan.backend.school.repository.SchoolRepository;
import uz.ksan.backend.school.service.SchoolService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Transactional
@RequestMapping("/api/v1/schools")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SchoolController {

    @Autowired
    SchoolService schoolService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveSchool(@RequestBody School school) {
        schoolService.saveSchool(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> findAllSchools() {
        return ResponseEntity.ok(schoolService.findAllSchools());
    }

    @GetMapping("/with-students/{schoolId}")
    public ResponseEntity<FullSchoolResponse> findAllSchools(@PathVariable("schoolId") Long schoolId) {
        return ResponseEntity.ok(schoolService.findAllSchoolsWithStudents(schoolId));
    }

}
