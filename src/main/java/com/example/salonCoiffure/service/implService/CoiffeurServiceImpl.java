package com.example.salonCoiffure.service.implService;

import com.example.salonCoiffure.dto.CoiffeurDTO;
import com.example.salonCoiffure.entities.Coiffeur;
import com.example.salonCoiffure.entities.Proprietaire;
import com.example.salonCoiffure.repositories.CoiffeurRepository;
import com.example.salonCoiffure.service.interfaceService.CoiffeurService;
import com.example.salonCoiffure.utils.CoiffeurSpecification;
import com.example.salonCoiffure.utils.Mapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoiffeurServiceImpl implements CoiffeurService {

    private final CoiffeurRepository repository;
    private final Mapper mapper;

    public CoiffeurServiceImpl(CoiffeurRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Coiffeur add(CoiffeurDTO coiffeurDTO) {
        return mapper.map(repository.save(mapper.map(coiffeurDTO, Coiffeur.class)),Coiffeur.class);
    }

    @Override
    public Page<Coiffeur> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
    public Page<Coiffeur> findByMotCle(Pageable pageable,String motCle) {
        Specification<Coiffeur> spec= CoiffeurSpecification.searchWithKeyword(motCle);
        return repository.findAll(spec,pageable);
    }
    @Override
    public CoiffeurDTO getById(long id) {
        Coiffeur customers=repository.findById(id).get();
        return mapper.map(customers,CoiffeurDTO.class);
    }

    @Override
    public void update(long id, CoiffeurDTO coiffeurDTO) {
        Optional<Coiffeur> customers=repository.findById(id);
        if(customers.isPresent()){
            Coiffeur customers1=customers.get();
            customers1.setProprietaire(coiffeurDTO.getProprietaire());
            customers1.setEmailCoiffeur(coiffeurDTO.getEmailCoiffeur());
            customers1.setCinCoiffeur(coiffeurDTO.getCinCoiffeur());
            customers1.setNomCoiffeur(coiffeurDTO.getNomCoiffeur());
            customers1.setPrenomCoiffeur(coiffeurDTO.getPrenomCoiffeur());
            customers1.setSalon(coiffeurDTO.getSalon());
            customers1.setTelCoiffeur(coiffeurDTO.getTelCoiffeur());
            repository.save(customers1);
        }
    }

    @Override
    public void delete(long id) {
        Optional<Coiffeur> customers=repository.findById(id);
        if(customers.isPresent()){
            repository.deleteById(id);
        }else {
            throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
        }
    }
}
