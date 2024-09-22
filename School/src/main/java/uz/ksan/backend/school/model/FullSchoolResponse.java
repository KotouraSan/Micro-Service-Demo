package uz.ksan.backend.school.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnTransformer;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FullSchoolResponse implements Serializable{

    @ColumnTransformer(write = "LOWER(?)")
    String name;

    @ColumnTransformer(write = "LOWER(?)")
    String address;

    @ColumnTransformer(write = "LOWER(?)")
    String email;

    List<Student> students;
}
