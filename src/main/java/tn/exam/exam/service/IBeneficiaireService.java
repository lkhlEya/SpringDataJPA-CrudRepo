package tn.exam.exam.service;

import tn.exam.exam.entity.Beneficiaire;

import java.util.List;

public interface IBeneficiaireService {
    List<Beneficiaire> getAllBeneficiaires();

    Beneficiaire getBeneficiaire(int id);

    Beneficiaire addBeneficiaire(Beneficiaire u);

    Beneficiaire updateBeneficiaire(Beneficiaire u);

    boolean deleteBeneficiaire(int id);
}
