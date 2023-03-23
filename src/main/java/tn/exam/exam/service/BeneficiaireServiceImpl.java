package tn.exam.exam.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.exam.exam.entity.Beneficiaire;
import tn.exam.exam.repository.BeneficiaireRepository;

import java.util.List;
import java.util.TreeMap;

@Service
@Slf4j
public class BeneficiaireServiceImpl implements  IBeneficiaireService{
    @Autowired
    BeneficiaireRepository beneficiaireRepository;

    @Override
    public List<Beneficiaire> getAllBeneficiaires()
    {
        return beneficiaireRepository.findAll();
    }

    @Override
    public Beneficiaire getBeneficiaire(int id)
    {
        return beneficiaireRepository.findById(id).orElse(null);
    }


    @Override
    public Beneficiaire addBeneficiaire(Beneficiaire u)
    {
        return beneficiaireRepository.saveAndFlush(u);
    }

    @Override
    public Beneficiaire updateBeneficiaire(Beneficiaire u)
    {
        return beneficiaireRepository.saveAndFlush(u);
    }

    @Override
    public boolean deleteBeneficiaire(int id)
    {
        beneficiaireRepository.deleteById(id);
        return (!beneficiaireRepository.existsById(id));

    }
/*
    @Scheduled(fixedRate = 60000)
    public void statique()
    {
        TreeMap<Beneficiaire , >  Beneficiaire beneficiaire = beneficiaireRepository.findAll();

    }

 */
}
