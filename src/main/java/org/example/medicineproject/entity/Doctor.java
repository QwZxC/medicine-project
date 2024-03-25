package org.example.medicineproject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Doctor {

    @Id
    @Column(name = "uuid", nullable = false)
    private UUID uuid;
    @Column(name = "firstname", nullable = false)
    private String firstName;
    @Column(name = "lastName", nullable = false)
    private String lastName;
    @Column(name = "middleName")
    private String middleName;
    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
}
