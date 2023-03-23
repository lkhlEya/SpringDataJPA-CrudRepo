package tn.exam.exam.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Assurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idAssurance;

    String designation;
    float montant;

    @ManyToOne(cascade = CascadeType.ALL)
    Contrat contrat;

    @JsonBackReference(value="assurance")
    @ManyToOne(cascade = CascadeType.ALL)
    Beneficiaire beneficiaire;
}
