package com.example.salonCoiffure.service.interfaceService;

import com.example.salonCoiffure.dto.ServiceDTO;
import com.example.salonCoiffure.entities.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceService {
    Service add(ServiceDTO serviceDTO);
    Page<Service> getAll(Pageable pageable);
    //    Page<Customers> getAll(Pageable pageable, String cin, String nom, String prenom, String adresse);
    ServiceDTO getById(long id);
    void update(long id,ServiceDTO serviceDTO);
    void delete(long id);
}
