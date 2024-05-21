package com.example.salonCoiffure.controllers;

import com.example.salonCoiffure.dto.CoiffeurDTO;
import com.example.salonCoiffure.dto.ProprietaireDTO;
import com.example.salonCoiffure.entities.Proprietaire;
import com.example.salonCoiffure.service.implService.ProprietaireServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proprietaire")
public class ProprietaireController {

    private final ProprietaireServiceImpl service;

    public ProprietaireController(ProprietaireServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<Proprietaire>> getAll(@PageableDefault(page = 0,size = 5)Pageable pageable){
        Page<Proprietaire> proprietaires=service.getAll( pageable);
        return new ResponseEntity<>(proprietaires, HttpStatus.OK);
    }
    @GetMapping("/filter")
    public ResponseEntity<Page<Proprietaire>> findByMotCle(@PageableDefault(page = 0,size = 5)Pageable pageable, @RequestParam(required = false) String motCle){
        Page<Proprietaire> proprietaires=service.findByMotCle(motCle, pageable);
        return new ResponseEntity<>(proprietaires, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Void> Create(@RequestBody ProprietaireDTO customersDTO){
        service.add(customersDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProprietaireDTO> getById(@PathVariable Long id) {
        ProprietaireDTO agentDTO = service.getById(id);
        return new ResponseEntity<>(agentDTO, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody ProprietaireDTO agentDTO){
        ProprietaireDTO agentDTO1=service.getById(id);
        if(!id.equals(agentDTO1.getId())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            service.update(id,agentDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        ProprietaireDTO agentDTO1=service.getById(id);
        if(!id.equals(agentDTO1.getId())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
