package tn.exam.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.exam.exam.entity.Assurance;
import tn.exam.exam.service.IAssuranceService;

import java.util.List;

@RestController
@RequestMapping("/assurance")
public class AssuranceController {
    @Autowired
    IAssuranceService assuranceService;


    @GetMapping("/all")
    @ResponseBody
    public List<Assurance> getAll() {
        return assuranceService.getAllAssurances();
    }


    @GetMapping("/{id}")
    @ResponseBody
    public Assurance getById(@PathVariable("id") int id) {
        return assuranceService.getAssurance(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public Assurance addAssurance(@RequestBody Assurance Assurance) {
        return assuranceService.addAssurance(Assurance);
    }

    @PostMapping("/update")
    @ResponseBody
    public Assurance updateAssurance(@RequestBody Assurance Assurance) {
        return assuranceService.updateAssurance(Assurance);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Boolean deleteAssurance(@PathVariable int id)
    {
        return assuranceService.deleteAssurance(id);
    }

    @PostMapping("/ajouterAssurance/{cinBF}/{matricule}")
    @ResponseBody
    public Assurance ajouterAssurance(@RequestBody Assurance Assurance,@PathVariable("cinBF") int cinBF,@PathVariable("matricule") String matricule) {
        return assuranceService.addAssuranceIncludeContBenef(Assurance,cinBF,matricule);
    }
}
