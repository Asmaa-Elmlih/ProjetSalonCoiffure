package com.example.salonCoiffure.controllers;

import com.example.salonCoiffure.dto.ClientDTO;
import com.example.salonCoiffure.dto.CoiffeurDTO;
import com.example.salonCoiffure.entities.Client;
import com.example.salonCoiffure.service.implService.ClientServiceImpl;
import com.example.salonCoiffure.utils.ClientSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientServiceImpl service;


    public ClientController(ClientServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<Client>> getAll(@PageableDefault(size = 5, page = 0) Pageable pageable){
        Page<Client> clientsPage = service.getAll(pageable);
        return new ResponseEntity<>(clientsPage, HttpStatus.OK);
    }
    @GetMapping("/filter")
    public ResponseEntity<Page<Client>> findByMotCle(@RequestParam(required = false) String motCle,@PageableDefault(size = 5, page = 0) Pageable pageable){
        Page<Client> clientsPage = service.findByMotCle(pageable, motCle);
        return new ResponseEntity<>(clientsPage, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Client> Create(@RequestBody ClientDTO clientDTO){
        System.out.println("Create");
        service.add(clientDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getById(@PathVariable Long id) {
        ClientDTO agentDTO = service.getById(id);
        return new ResponseEntity<>(agentDTO, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody ClientDTO agentDTO){
        ClientDTO agentDTO1=service.getById(id);
        if(!id.equals(agentDTO1.getId())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            service.update(id,agentDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        ClientDTO agentDTO1=service.getById(id);
        if(!id.equals(agentDTO1.getId())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
