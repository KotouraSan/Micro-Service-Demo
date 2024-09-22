package uz.ksan.backend.school.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnTransformer;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student implements Serializable {

    @ColumnTransformer(write = "LOWER(?)")
    String firstName;
    @ColumnTransformer(write = "LOWER(?)")
    String lastName;
    String email;
}