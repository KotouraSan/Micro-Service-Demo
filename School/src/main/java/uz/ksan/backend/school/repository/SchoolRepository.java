package uz.ksan.backend.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ksan.backend.school.model.School;

public interface SchoolRepository extends JpaRepository<School, Long> {

}
