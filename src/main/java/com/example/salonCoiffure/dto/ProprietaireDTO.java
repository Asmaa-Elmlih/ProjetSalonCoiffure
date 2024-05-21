package com.example.salonCoiffure.dto;

import com.example.salonCoiffure.entities.Coiffeur;
import com.example.salonCoiffure.entities.Salon;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProprietaireDTO {
    private Long id;
    private String nomProprietaire;
    private String prenomProprietaire;
    private String telProprietaire;
    private String emailProprietaire;
    private String cinProprietaire;
    private List<Salon> salonList;
    private List<Coiffeur> coiffeurList;
}
