package com.example.salonCoiffure.dto;

import com.example.salonCoiffure.entities.Coiffeur;
import com.example.salonCoiffure.entities.Service;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoiffeurSalonDTO {
    private Long id;

    private Coiffeur coiffeur;

    private Service service;
}
