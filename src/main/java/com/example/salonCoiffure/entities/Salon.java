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
public class Salon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomSalon;
    private String addresse;
    @ManyToOne
    private Proprietaire proprietaire;
    @OneToMany(mappedBy = "salon")
    @JsonIgnore
    private List<Coiffeur> coiffeurList;
    @OneToMany(mappedBy = "salon")
    @JsonIgnore
    private List<Client> clientList;
}
