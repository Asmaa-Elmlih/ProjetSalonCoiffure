package com.example.salonCoiffure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoiffeurSalon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coiffeur_id")
    private Coiffeur coiffeur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Service_id")
    private Service service;
}
