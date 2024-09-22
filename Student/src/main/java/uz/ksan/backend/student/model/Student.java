package uz.ksan.backend.student.model;

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
@Entity
@Table(name = "students")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student implements Serializable {

    @SequenceGenerator(name="yourSequenceGeneratorClient", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="yourSequenceGeneratorClient")
    @Id
    Long id;
    @ColumnTransformer(write = "LOWER(?)")
    String firstName;
    @ColumnTransformer(write = "LOWER(?)")
    String lastName;
    String email;
    @NonNull
    Long schoolId;


}
