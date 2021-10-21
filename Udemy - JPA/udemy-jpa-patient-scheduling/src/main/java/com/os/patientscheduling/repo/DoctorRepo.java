package com.os.patientscheduling.repo;

import org.springframework.data.repository.CrudRepository;

import com.os.patientscheduling.entities.Doctor;

public interface DoctorRepo extends CrudRepository<Doctor, Long> {

}
