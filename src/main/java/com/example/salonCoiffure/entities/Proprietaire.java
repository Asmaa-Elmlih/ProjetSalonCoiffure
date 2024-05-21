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
public class Proprietaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomProprietaire;
    private String prenomProprietaire;
    private String telProprietaire;
    private String emailProprietaire;
    private String cinProprietaire;
    @OneToMany(mappedBy = "proprietaire")
    @JsonIgnore
    private List<Salon> salonList;
    @OneToMany(mappedBy = "proprietaire")
    @JsonIgnore
    private List<Coiffeur> coiffeurList;
}
