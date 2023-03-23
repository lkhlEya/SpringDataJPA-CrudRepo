package tn.exam.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.exam.exam.entity.Assurance;


@Repository
public interface AssuranceRepository extends JpaRepository<Assurance, Integer> {
}
