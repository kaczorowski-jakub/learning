package com.os.patientscheduling;

import java.time.LocalDate;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.os.patientscheduling.entities.Appointment;
import com.os.patientscheduling.entities.Doctor;
import com.os.patientscheduling.entities.Insurance;
import com.os.patientscheduling.entities.Patient;
import com.os.patientscheduling.repo.AppointmentRepo;
import com.os.patientscheduling.repo.DoctorRepo;
import com.os.patientscheduling.repo.PatientRepo;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PatientSchedulingApplicationTest {
    
    @Autowired
    DoctorRepo doctorRepo;
    
    @Autowired
    PatientRepo patientRepo;
    
    @Autowired
    AppointmentRepo appointmentRepo;
    
    @Test
    public void createDoctorTest() {
        Doctor doctor = new Doctor();
        doctor.setFirstName("John");
        doctor.setLastName("Smith");
        doctor.setSpeciality("All");
        doctorRepo.save(doctor);
    }
    
    @Test
    public void createPatientTest() {
        Insurance insurance = new Insurance();
        insurance.setCopay(12.43d);
        insurance.setProviderName("ABC");
        
        Doctor doc = doctorRepo.findById(1l).get();
        
        Patient patient = new Patient();
        patient.setFirstName("Amy");
        patient.setLastName("McArthur");
        patient.setPhone("123-4567-890");
        patient.setInsurence(insurance);
        patient.setDoctors(Lists.list(doc));
        
        patientRepo.save(patient);
    }
    
    @Test
    public void createAppointmentTest() {
        
        Appointment appointment = new Appointment();
        appointment.setAppointmentTime(LocalDate.now());
        appointment.setReason("Flu");
        appointment.setStarted(true);
        appointment.setEnded(false);
        appointment.setDoctor(doctorRepo.findById(1l).get());
        appointment.setPatient(patientRepo.findById(1l).get());
        appointmentRepo.save(appointment);
        
    }
    
}
