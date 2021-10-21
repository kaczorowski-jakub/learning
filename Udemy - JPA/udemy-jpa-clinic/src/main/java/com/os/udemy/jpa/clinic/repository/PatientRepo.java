package com.os.udemy.jpa.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.os.udemy.jpa.clinic.entity.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer> {

}
