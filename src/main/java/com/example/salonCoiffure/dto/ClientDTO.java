package com.example.salonCoiffure.dto;

import com.example.salonCoiffure.entities.Salon;
import com.example.salonCoiffure.entities.Service;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private Long id;
    private String nomClient;
    private String prenomClient;
    private String cinClient;
    private String telClient;
    private String emailClient;
    private Salon salon;
    @JsonIgnore
    private List<Service> serviceList;
}
