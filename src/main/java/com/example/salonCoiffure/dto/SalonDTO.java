package com.example.salonCoiffure.dto;

import com.example.salonCoiffure.entities.Client;
import com.example.salonCoiffure.entities.Coiffeur;
import com.example.salonCoiffure.entities.Proprietaire;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalonDTO {
    private Long id;
    private String nomSalon;
    private String addresse;
    private Proprietaire proprietaire;
    private List<Coiffeur> coiffeurList;
    @JsonIgnore
    private List<Client> clientList;
}
