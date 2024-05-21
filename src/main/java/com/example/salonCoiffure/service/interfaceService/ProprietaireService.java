package com.example.salonCoiffure.service.interfaceService;

import com.example.salonCoiffure.dto.ProprietaireDTO;
import com.example.salonCoiffure.entities.Proprietaire;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProprietaireService {
    Proprietaire add(ProprietaireDTO proprietaireDTO);
    Page<Proprietaire> getAll( Pageable pageable);
    //    Page<Customers> getAll(Pageable pageable, String cin, String nom, String prenom, String adresse);
    ProprietaireDTO getById(long id);
    void update(long id,ProprietaireDTO proprietaireDTO);
    void delete(long id);
}
