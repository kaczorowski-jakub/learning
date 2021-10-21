package com.os.patientscheduling.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Insurance {
    
    @Column(name = "provider_name")
    private String providerName;
    private double copay;
    
}
