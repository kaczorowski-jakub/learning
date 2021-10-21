package com.os.patientscheduling.repo;

import org.springframework.data.repository.CrudRepository;

import com.os.patientscheduling.entities.Patient;

public interface PatientRepo extends CrudRepository<Patient, Long>{

}
