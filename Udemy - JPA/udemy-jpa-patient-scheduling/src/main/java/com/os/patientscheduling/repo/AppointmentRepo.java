package com.os.patientscheduling.repo;

import org.springframework.data.repository.CrudRepository;

import com.os.patientscheduling.entities.Appointment;

public interface AppointmentRepo extends CrudRepository<Appointment, Long>{

}
