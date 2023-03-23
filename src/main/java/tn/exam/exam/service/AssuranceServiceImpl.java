package tn.exam.exam.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.exam.exam.entity.Assurance;
import tn.exam.exam.entity.Beneficiaire;
import tn.exam.exam.entity.Contrat;
import tn.exam.exam.repository.AssuranceRepository;
import tn.exam.exam.repository.BeneficiaireRepository;
import tn.exam.exam.repository.ContratRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class AssuranceServiceImpl implements  IAssuranceService{
    @Autowired
    AssuranceRepository assuranceRepository;
    @Autowired
    BeneficiaireRepository beneficiaireRepository;
    @Autowired
    ContratRepository contratRepository;


    @Override
    public List<Assurance> getAllAssurances()
    {
        return assuranceRepository.findAll();
    }

    @Override
    public Assurance getAssurance(int id)
    {
        return assuranceRepository.findById(id).orElse(null);
    }


    @Override
    public Assurance addAssurance(Assurance u)
    {
        return assuranceRepository.saveAndFlush(u);
    }

    @Override
    public Assurance updateAssurance(Assurance u)
    {
        return assuranceRepository.saveAndFlush(u);
    }

    @Override
    public boolean deleteAssurance(int id)
    {
        assuranceRepository.deleteById(id);
        return (!assuranceRepository.existsById(id));

    }

    @Override
    public Assurance addAssuranceIncludeContBenef(Assurance assurance, int cinBF, String matricule) {

        Beneficiaire beneficiaire = beneficiaireRepository.findBeneficiaireByCin(cinBF);
        Contrat contrat = contratRepository.findContratByMatricule(matricule);

        if (beneficiaire != null && contrat != null) {
            assuranceRepository.saveAndFlush(assurance);

            if (beneficiaire.getAssurances().isEmpty()) {
                Set<Assurance> assurances = new HashSet<Assurance>();
                assurances.add(assurance);
            } else {
                if (!beneficiaire.getAssurances().contains(assurance)) {
                    beneficiaire.getAssurances().add(assurance);
                    beneficiaireRepository.save(beneficiaire);
                }
            }
        }
    return assurance;
    }
}
