package com.example.salonCoiffure.service.implService;

import com.example.salonCoiffure.dto.ServiceDTO;
import com.example.salonCoiffure.entities.Service;
import com.example.salonCoiffure.repositories.ServiceRepository;
import com.example.salonCoiffure.service.interfaceService.ServiceService;
import com.example.salonCoiffure.utils.Mapper;
import com.example.salonCoiffure.utils.ServiceSpecification;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository repository;
    private Mapper mapper;

    public ServiceServiceImpl(ServiceRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Service add(ServiceDTO serviceDTO) {
        return mapper.map(repository.save(mapper.map(serviceDTO, Service.class)),Service.class);
    }

    @Override
    public Page<Service> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
    public Page<Service> findByMotCle(String motCle,Pageable pageable) {
        Specification<Service> spec= ServiceSpecification.searchWithKeyword(motCle);
        return repository.findAll(spec,pageable);
    }

    @Override
    public ServiceDTO getById(long id) {
        Service customers=repository.findById(id).get();
        return mapper.map(customers,ServiceDTO.class);
    }

    @Override
    public void update(long id, ServiceDTO serviceDTO) {
        Optional<Service> customers=repository.findById(id);
        if(customers.isPresent()){
            Service customers1=customers.get();
            customers1.setDescription(serviceDTO.getDescription());
            customers1.setPrixService(serviceDTO.getPrixService());
            customers1.setNomService(serviceDTO.getNomService());
            repository.save(customers1);
        }
    }

    @Override
    public void delete(long id) {
        Optional<Service> customers=repository.findById(id);
        if(customers.isPresent()){
            repository.deleteById(id);
        }else {
            throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
        }
    }
}
