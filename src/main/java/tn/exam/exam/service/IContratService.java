package tn.exam.exam.service;

import tn.exam.exam.entity.Contrat;

import java.util.List;

public interface IContratService {
    List<Contrat> getAllContrats();

    Contrat getContrat(int id);

    Contrat addContrat(Contrat u);

    Contrat updateContrat(Contrat u);

    boolean deleteContrat(int id);

}
