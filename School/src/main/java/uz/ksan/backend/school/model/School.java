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
@Entity
@Table(name = "schools")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class School implements Serializable {

    @SequenceGenerator(name="yourSequenceGeneratorClient", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="yourSequenceGeneratorClient")
    @Id
    Long id;

    @ColumnTransformer(write = "LOWER(?)")
    String name;

    @ColumnTransformer(write = "LOWER(?)")
    String address;

    @ColumnTransformer(write = "LOWER(?)")
    String email;

}
