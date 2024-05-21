package com.example.salonCoiffure.service.interfaceService;

import com.example.salonCoiffure.dto.ClientDTO;
import com.example.salonCoiffure.dto.CoiffeurDTO;
import com.example.salonCoiffure.entities.Client;
import com.example.salonCoiffure.entities.Coiffeur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientService {
    Client add(ClientDTO clientDTO);
//    List<ClientDTO> getAll();
    Page<Client> getAll(Pageable pageable);

    //    Page<Customers> getAll(Pageable pageable, String cin, String nom, String prenom, String adresse);
    ClientDTO getById(long id);
    void update(long id,ClientDTO clientDTO);
    void delete(long id);

}
