package org.example.medicineproject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String name;
    @ManyToOne
    @JoinColumn(name = "county_id")
    private County county;
    @OneToMany(mappedBy = "region")
    private List<City> cities = new ArrayList<>();
}
