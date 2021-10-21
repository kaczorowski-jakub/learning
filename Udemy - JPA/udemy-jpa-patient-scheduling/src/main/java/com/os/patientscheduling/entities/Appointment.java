package com.os.patientscheduling.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Appointment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "appointment_time")
    private LocalDate appointmentTime;
    
    private Boolean started;
    private Boolean ended;
    private String reason;
    
    @ManyToOne
    @JoinColumn(name = "doctor_ident")
    private Doctor doctor;
    
    @ManyToOne
    @JoinColumn(name = "patient_ident")
    private Patient patient;
    
}
