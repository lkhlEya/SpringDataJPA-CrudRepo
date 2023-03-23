package tn.exam.exam.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idContrat;

    String matricule;
    @Temporal(TemporalType.DATE)
    Date dateEffet;

    @Enumerated(EnumType.STRING)
    TypContrat typContrat;



}
