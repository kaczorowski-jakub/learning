package com.os.udemy.jpa.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.os.udemy.jpa.clinic.dto.ClinicalDataDTO;
import com.os.udemy.jpa.clinic.entity.ClinicalData;
import com.os.udemy.jpa.clinic.entity.Patient;
import com.os.udemy.jpa.clinic.repository.ClinicalDataRepo;
import com.os.udemy.jpa.clinic.repository.PatientRepo;

@RestController
@RequestMapping("/clinicaldata")
@CrossOrigin
public class ClinicalDataController {
    
    private final ClinicalDataRepo clinicalRepo;
    private final PatientRepo patientRepo;
    
    @Autowired
    public ClinicalDataController(final ClinicalDataRepo clinicalRepo, final PatientRepo patientRepo) {
        this.clinicalRepo = clinicalRepo;
        this.patientRepo = patientRepo;
    }
    
    @PostMapping
    public ClinicalData saveClinicalData(@RequestBody ClinicalDataDTO request) {
        Patient p = patientRepo.findById(request.getPatientId()).get();
        ClinicalData cd = new ClinicalData();
        cd.setComponentName(request.getComponentName());
        cd.setComponentValue(request.getComponentValue());
        cd.setPatient(p);
        return clinicalRepo.save(cd);
    }
    
}
