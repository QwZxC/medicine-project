package org.example.medicineproject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Hospital {

    @Id
    @Column(name = "uuid", nullable = false)
    private UUID uuid;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "hospital")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "hospital")
    private List<Doctor> doctors = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    @OneToMany(mappedBy = "hospital")
    private List<FavoriteHospital> favoriteHospitals = new ArrayList<>();
}
