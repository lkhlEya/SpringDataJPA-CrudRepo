package tn.exam.exam.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Beneficiaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idBenef;
    int cin;

    String nom;
    String prenom;
    String profession;
    float salaire;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="beneficiaire")
   // @JsonManagedReference(value="assurances")
    private Set<Assurance> assurances;
}
