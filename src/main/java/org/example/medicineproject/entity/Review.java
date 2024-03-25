package org.example.medicineproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.medicineproject.entity.user.User;

import java.util.UUID;

@Data
@Entity
public class Review {

    @Id
    @Column(name = "uuid", nullable = false)
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "rating", nullable = false)
    private Integer rating;
}
