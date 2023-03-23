package tn.exam.exam.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.exam.exam.entity.Assurance;
import tn.exam.exam.entity.Beneficiaire;
import tn.exam.exam.entity.Contrat;
import tn.exam.exam.repository.BeneficiaireRepository;
import tn.exam.exam.repository.ContratRepository;

import java.util.List;

@Service
@Slf4j
public class ContratServiceImpl implements  IContratService{
    @Autowired
    ContratRepository contratRepository;
    @Autowired
    BeneficiaireRepository beneficiaireRepository;
    @Override
    public List<Contrat> getAllContrats()
    {
        return contratRepository.findAll();
    }

    @Override
    public Contrat getContrat(int id)
    {
        return contratRepository.findById(id).orElse(null);
    }


    @Override
    public Contrat addContrat(Contrat u)
    {
        return contratRepository.saveAndFlush(u);
    }

    @Override
    public Contrat updateContrat(Contrat u)
    {
        return contratRepository.saveAndFlush(u);
    }

    @Override
    public boolean deleteContrat(int id)
    {
        contratRepository.deleteById(id);
        return (!contratRepository.existsById(id));

    }


}
