package com.example.salonCoiffure.controllers;

import com.example.salonCoiffure.dto.CoiffeurDTO;
import com.example.salonCoiffure.entities.Coiffeur;
import com.example.salonCoiffure.service.implService.CoiffeurServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coiffeur")
public class CoiffeurController {
    private final CoiffeurServiceImpl service;

    public CoiffeurController(CoiffeurServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<Coiffeur>> getAll(@PageableDefault(page = 0,size = 5)Pageable pageable){
        Page<Coiffeur> coiffeurs=service.getAll(pageable);
        return new ResponseEntity<>(coiffeurs, HttpStatus.OK);
    }
    @GetMapping("/filter")
    public ResponseEntity<Page<Coiffeur>> findByMotCle(@PageableDefault(page = 0,size = 5)Pageable pageable, @RequestParam(required = false) String motCle){
        Page<Coiffeur> coiffeurs=service.findByMotCle(pageable, motCle);
        return new ResponseEntity<>(coiffeurs, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Void> Create(@RequestBody CoiffeurDTO customersDTO){
        service.add(customersDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CoiffeurDTO> getById(@PathVariable Long id) {
        CoiffeurDTO agentDTO = service.getById(id);
        return new ResponseEntity<>(agentDTO, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody CoiffeurDTO agentDTO){
        CoiffeurDTO agentDTO1=service.getById(id);
        if(!id.equals(agentDTO1.getId())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            service.update(id,agentDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        CoiffeurDTO agentDTO1=service.getById(id);
        if(!id.equals(agentDTO1.getId())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
