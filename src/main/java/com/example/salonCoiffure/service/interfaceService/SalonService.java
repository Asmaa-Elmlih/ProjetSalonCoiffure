package com.example.salonCoiffure.service.interfaceService;

import com.example.salonCoiffure.dto.SalonDTO;
import com.example.salonCoiffure.entities.Salon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SalonService {
    Salon add(SalonDTO salonDTO);
    Page<Salon> getAll(Pageable pageable);
    //    Page<Customers> getAll(Pageable pageable, String cin, String nom, String prenom, String adresse);
    SalonDTO getById(long id);
    void update(long id,SalonDTO salonDTO);
    void delete(long id);
}
