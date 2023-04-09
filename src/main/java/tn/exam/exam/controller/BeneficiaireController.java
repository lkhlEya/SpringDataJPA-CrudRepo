package tn.exam.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.exam.exam.entity.Beneficiaire;
import tn.exam.exam.service.IBeneficiaireService;

import java.util.List;

@RestController
@RequestMapping("/beneficiaire")
public class BeneficiaireController {
    @Autowired
    IBeneficiaireService beneficiaireService;



    @GetMapping("/all")
    @ResponseBody
    public List<Beneficiaire> getAll() {
        return beneficiaireService.getAllBeneficiaires();
    }


    @GetMapping("/{id}")
    @ResponseBody
    public Beneficiaire getById(@PathVariable("id") int id) {
        return beneficiaireService.getBeneficiaire(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public Beneficiaire addBeneficiaire(@RequestBody Beneficiaire beneficiaire) {
        return beneficiaireService.addBeneficiaire(beneficiaire);
    }

    @PostMapping("/update")
    @ResponseBody
    public Beneficiaire updateBeneficiaire(@RequestBody Beneficiaire beneficiaire) {
        return beneficiaireService.updateBeneficiaire(beneficiaire);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Boolean deleteBeneficiaire(@PathVariable int id)
    {
        return beneficiaireService.deleteBeneficiaire(id);
    }

}
