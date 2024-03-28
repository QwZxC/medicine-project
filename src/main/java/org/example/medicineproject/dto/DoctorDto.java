package org.example.medicineproject.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorDto {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String middleName;
}
