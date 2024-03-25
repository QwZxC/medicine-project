package org.example.medicineproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class HospitalDto {

    private UUID uuid;

    private String name;
    private Integer rating;
}
