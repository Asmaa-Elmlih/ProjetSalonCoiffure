package com.example.salonCoiffure.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coiffeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomCoiffeur;
    private String prenomCoiffeur;
    private String cinCoiffeur;
    private String telCoiffeur;
    private String emailCoiffeur;
    @ManyToOne
    private Proprietaire proprietaire;
    @ManyToOne
    private Salon salon;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "CoiffeurSalon",
            joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = @JoinColumn(name = "coiffeur_id"))
    private List<Service> serviceList;
}
