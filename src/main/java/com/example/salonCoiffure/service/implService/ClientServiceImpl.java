package com.example.salonCoiffure.service.implService;

import com.example.salonCoiffure.dto.ClientDTO;
import com.example.salonCoiffure.entities.Client;
import com.example.salonCoiffure.entities.Salon;
import com.example.salonCoiffure.repositories.ClientRepository;
import com.example.salonCoiffure.repositories.SalonRepository;
import com.example.salonCoiffure.service.interfaceService.ClientService;
import com.example.salonCoiffure.utils.ClientSpecification;
import com.example.salonCoiffure.utils.Mapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository repository;
    private final SalonRepository salonRepository;
    private final ClientSpecification clientSpecification;
    private final Mapper mapper;

    public ClientServiceImpl(ClientRepository repository, SalonRepository salonRepository, ClientSpecification clientSpecification, Mapper mapper) {
        this.repository = repository;
        this.salonRepository = salonRepository;
        this.clientSpecification = clientSpecification;
        this.mapper = mapper;
    }

    @Override
    public Client add(ClientDTO clientDTO) {
        try{
        Optional<Salon> salonOptional=salonRepository.findById(clientDTO.getSalon().getId());
        if(salonOptional.isPresent()){
            Client client=mapper.map(clientDTO,Client.class);
            client.setSalon(clientDTO.getSalon());
            return repository.save(client);
        }else{
            throw new IllegalArgumentException("Certaines entités associées n'ont pas été trouvées.");
        }
    } catch (Exception ex) {
        throw new IllegalArgumentException("Erreur lors de l'ajout de deces : " + ex.getMessage());
    }
    }

    @Override
    public Page<Client> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }


    public Page<Client> findByMotCle(Pageable pageable, String motCle) {
        Specification<Client> spec=ClientSpecification.searchWithKeyword(motCle);
        return repository.findAll(spec, pageable);

    }

    @Override
    public ClientDTO getById(long id) {
        Client customers=repository.findById(id).get();
        return mapper.map(customers,ClientDTO.class);
    }

    @Override
    public void update(long id, ClientDTO clientDTO) {
        Optional<Client> customers=repository.findById(id);
        if(customers.isPresent()){
            Client customers1=customers.get();
            customers1.setCinClient(clientDTO.getCinClient());
            customers1.setNomClient(clientDTO.getNomClient());
            customers1.setPrenomClient(clientDTO.getPrenomClient());
            customers1.setCinClient(clientDTO.getCinClient());
            customers1.setSalon(clientDTO.getSalon());
            customers1.setEmailClient(clientDTO.getEmailClient());
            customers1.setTelClient(clientDTO.getTelClient());
            repository.save(customers1);
        }
    }

    @Override
    public void delete(long id) {
        Optional<Client> customers=repository.findById(id);
        if(customers.isPresent()){
            repository.deleteById(id);
        }else {
            throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
        }
    }
}
