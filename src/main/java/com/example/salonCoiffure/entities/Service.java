package com.example.salonCoiffure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomService;
    private String description;
    private Double prixService;
    @ManyToMany(mappedBy = "serviceList", fetch = FetchType.LAZY)
    private List<Coiffeur> coiffeurList;
    @ManyToMany(mappedBy = "serviceList", fetch = FetchType.LAZY)
    private List<Client> clientList;
}
