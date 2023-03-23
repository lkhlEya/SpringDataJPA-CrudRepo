package tn.exam.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.exam.exam.entity.Assurance;
import tn.exam.exam.entity.Contrat;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Integer> {
    Contrat findContratByMatricule(String matricule);

}
