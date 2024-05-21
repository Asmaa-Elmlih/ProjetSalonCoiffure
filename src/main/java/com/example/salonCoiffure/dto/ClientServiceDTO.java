package com.example.salonCoiffure.dto;

import com.example.salonCoiffure.entities.Client;
import com.example.salonCoiffure.entities.Service;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientServiceDTO {
    private Long id;

    private Client client;

    private Service service;
    private LocalDateTime dateService;
}
