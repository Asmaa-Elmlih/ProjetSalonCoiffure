package com.example.salonCoiffure.dto;

import com.example.salonCoiffure.entities.Client;
import com.example.salonCoiffure.entities.Coiffeur;
import jakarta.persistence.Access;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDTO {
    private Long id;
    private String nomService;
    private String description;
    private Double prixService;
    private List<Coiffeur> coiffeurList;
    private List<Client> clientList;
}
