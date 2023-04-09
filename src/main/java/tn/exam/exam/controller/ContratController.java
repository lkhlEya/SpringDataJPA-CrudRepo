package tn.exam.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.exam.exam.entity.Contrat;
import tn.exam.exam.service.IBeneficiaireService;
import tn.exam.exam.service.IContratService;

import java.util.List;

@RestController
@RequestMapping("/contrat")
public class ContratController {
    @Autowired
    IContratService contratService;

    @Autowired
    IBeneficiaireService beneficiaireService;


    @GetMapping("/all")
    @ResponseBody
    public List<Contrat> getAll() {
        return contratService.getAllContrats();
    }


    @GetMapping("/{id}")
    @ResponseBody
    public Contrat getById(@PathVariable("id") int id) {
        return contratService.getContrat(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public Contrat ajouterContrat(@RequestBody Contrat contrat) {
        return contratService.addContrat(contrat);
    }

    @PostMapping("/update")
    @ResponseBody
    public Contrat updateContrat(@RequestBody Contrat contrat) {
        return contratService.updateContrat(contrat);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Boolean deleteContrat(@PathVariable int id) {
        return contratService.deleteContrat(id);
    }

    /* @GetMapping("/ancien/{idBF}")
    @ResponseBody
    public Contrat getAll(@PathVariable("idBF") int idBF) {
        return beneficiaireService.getAncienContrats( idBF);
    }
*/
}
