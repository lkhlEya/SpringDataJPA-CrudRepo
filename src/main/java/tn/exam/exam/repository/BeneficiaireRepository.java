package tn.exam.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.exam.exam.entity.Beneficiaire;

import java.util.List;

@Repository
public interface BeneficiaireRepository extends JpaRepository<Beneficiaire, Integer> {
    Beneficiaire findBeneficiaireByCin(int cinBF);

}
