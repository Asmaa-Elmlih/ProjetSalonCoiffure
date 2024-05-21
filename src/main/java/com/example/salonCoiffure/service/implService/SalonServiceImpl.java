package com.example.salonCoiffure.service.implService;

import com.example.salonCoiffure.dto.SalonDTO;
import com.example.salonCoiffure.entities.Salon;
import com.example.salonCoiffure.repositories.SalonRepository;
import com.example.salonCoiffure.service.interfaceService.SalonService;
import com.example.salonCoiffure.utils.Mapper;
import com.example.salonCoiffure.utils.SalonSpecification;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalonServiceImpl implements SalonService {

    private final SalonRepository repository;
    private final Mapper mapper;

    public SalonServiceImpl(SalonRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Salon add(SalonDTO salonDTO) {
        return mapper.map(repository.save(mapper.map(salonDTO, Salon.class)),Salon.class);
    }

    @Override
    public Page<Salon> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<Salon> findByMotCle(Pageable pageable,String motCle) {
        Specification<Salon> spec= SalonSpecification.searchWithKeyword(motCle);
        return repository.findAll(spec,pageable);
    }

    @Override
    public SalonDTO getById(long id) {
        Salon customers=repository.findById(id).get();
        return mapper.map(customers,SalonDTO.class);
    }

    @Override
    public void update(long id, SalonDTO salonDTO) {
        Optional<Salon> customers=repository.findById(id);
        if(customers.isPresent()){
            Salon customers1=customers.get();
            customers1.setAddresse(salonDTO.getAddresse());
            customers1.setNomSalon(salonDTO.getNomSalon());
            customers1.setProprietaire(salonDTO.getProprietaire());
            repository.save(customers1);
        }
    }

    @Override
    public void delete(long id) {
        Optional<Salon> customers=repository.findById(id);
        if(customers.isPresent()){
            repository.deleteById(id);
        }else {
            throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
        }
    }
}
