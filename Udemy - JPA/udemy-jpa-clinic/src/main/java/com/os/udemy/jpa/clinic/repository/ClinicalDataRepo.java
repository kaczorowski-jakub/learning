package com.os.udemy.jpa.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.os.udemy.jpa.clinic.entity.ClinicalData;

public interface ClinicalDataRepo extends JpaRepository<ClinicalData, Integer>{

}
