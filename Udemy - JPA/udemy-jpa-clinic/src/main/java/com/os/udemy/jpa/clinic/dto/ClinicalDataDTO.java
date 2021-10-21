package com.os.udemy.jpa.clinic.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClinicalDataDTO {
    private String componentName;
    private String componentValue;
    private int patientId;
}
