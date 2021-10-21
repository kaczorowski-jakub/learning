package com.os.udemy.jpa.clinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.os.udemy.jpa.clinic.entity.ClinicalData;
import com.os.udemy.jpa.clinic.entity.Patient;
import com.os.udemy.jpa.clinic.repository.PatientRepo;

@RestController
@RequestMapping("/patients")
@CrossOrigin
public class PatientController {

    private final PatientRepo repo;

    @Autowired
    public PatientController(PatientRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Patient> getPatients() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable int id) {
        return repo.findById(id).get();
    }

    @PostMapping
    public Patient savePatient(@RequestBody Patient patient) {
        return repo.save(patient);
    }

    @GetMapping("/analyze/{id}")
    public Patient analyze(@PathVariable int id) {
        Patient p = repo.findById(id).get();
        List<ClinicalData> list = p.getClinicalData();
        if (list.size() > 0) {
            String hw = list.stream().filter(cd -> "hw".equals(cd.getComponentName())).findAny().get().getComponentValue();
            String[] heightAndWeight = hw.split("/");
            float heightInMeters = Float.parseFloat(heightAndWeight[0]) * 0.4536f;
            float bmi = Float.parseFloat(heightAndWeight[1]) / (heightInMeters * heightInMeters);
            ClinicalData cd = new ClinicalData();
            cd.setComponentName("bmi");
            cd.setComponentValue("" + bmi);
            cd.setPatient(p);
            list.add(cd);
        }
        
        return p;
    }
}
