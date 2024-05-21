package com.example.salonCoiffure.service.interfaceService;

import com.example.salonCoiffure.dto.CoiffeurDTO;
import com.example.salonCoiffure.entities.Coiffeur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CoiffeurService {
    Coiffeur add(CoiffeurDTO coiffeurDTO);
    Page<Coiffeur> getAll(Pageable pageable);
    //    Page<Customers> getAll(Pageable pageable, String cin, String nom, String prenom, String adresse);
    CoiffeurDTO getById(long id);
    void update(long id,CoiffeurDTO coiffeurDTO);
    void delete(long id);
}
