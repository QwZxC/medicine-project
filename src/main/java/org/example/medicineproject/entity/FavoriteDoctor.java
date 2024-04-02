package org.example.medicineproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.medicineproject.entity.user.User;

import java.util.UUID;

@Data
@Entity
public class FavoriteDoctor {

    @Id
    @Column(name = "uuid", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
