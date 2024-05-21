package com.example.salonCoiffure.service.implService;

import com.example.salonCoiffure.dto.ProprietaireDTO;
import com.example.salonCoiffure.entities.Proprietaire;
import com.example.salonCoiffure.entities.Salon;
import com.example.salonCoiffure.repositories.ProprietaireRepository;
import com.example.salonCoiffure.service.interfaceService.ProprietaireService;
import com.example.salonCoiffure.utils.Mapper;
import com.example.salonCoiffure.utils.ProprietaireSpecification;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProprietaireServiceImpl implements ProprietaireService {

    private final ProprietaireRepository repository;
    private final Mapper mapper;

    public ProprietaireServiceImpl(ProprietaireRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Proprietaire add(ProprietaireDTO proprietaireDTO) {
        return mapper.map(repository.save(mapper.map(proprietaireDTO, Proprietaire.class)),Proprietaire.class);
    }

    @Override
    public Page<Proprietaire> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
    public Page<Proprietaire> findByMotCle(String motCle, Pageable pageable) {
        Specification<Proprietaire> spec= ProprietaireSpecification.searchWithKeyword(motCle);
        return repository.findAll(spec,pageable);
    }

    @Override
    public ProprietaireDTO getById(long id) {
        Proprietaire customers=repository.findById(id).get();
        return mapper.map(customers,ProprietaireDTO.class);
    }

    @Override
    public void update(long id, ProprietaireDTO proprietaireDTO) {
        Optional<Proprietaire> customers=repository.findById(id);
        if(customers.isPresent()){
            Proprietaire customers1=customers.get();
            customers1.setEmailProprietaire(proprietaireDTO.getEmailProprietaire());
            customers1.setNomProprietaire(proprietaireDTO.getNomProprietaire());
            customers1.setPrenomProprietaire(proprietaireDTO.getPrenomProprietaire());
            customers1.setTelProprietaire(proprietaireDTO.getTelProprietaire());
            customers1.setCinProprietaire(proprietaireDTO.getCinProprietaire());
            repository.save(customers1);
        }
    }

    @Override
    public void delete(long id) {
        Optional<Proprietaire> customers=repository.findById(id);
        if(customers.isPresent()){
            repository.deleteById(id);
        }else {
            throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
        }
    }
}
