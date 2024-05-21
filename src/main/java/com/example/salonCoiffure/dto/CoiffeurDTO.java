package com.example.salonCoiffure.dto;

import com.example.salonCoiffure.entities.Proprietaire;
import com.example.salonCoiffure.entities.Salon;
import com.example.salonCoiffure.entities.Service;
import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoiffeurDTO {
    private Long id;
    private String nomCoiffeur;
    private String prenomCoiffeur;
    private String cinCoiffeur;
    private String telCoiffeur;
    private String emailCoiffeur;
    private Proprietaire proprietaire;
    private Salon salon;
    private List<Service> serviceList;
}
