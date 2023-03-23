package tn.exam.exam.service;

import tn.exam.exam.entity.Assurance;

import java.util.List;

public interface IAssuranceService {
    List<Assurance> getAllAssurances();

    Assurance getAssurance(int id);

    Assurance addAssurance(Assurance u);

    Assurance updateAssurance(Assurance u);

    boolean deleteAssurance(int id);

    Assurance addAssuranceIncludeContBenef(Assurance assurance, int cinBF, String matricule);
}
