package com.example.salonCoiffure.controllers;

import com.example.salonCoiffure.dto.ProprietaireDTO;
import com.example.salonCoiffure.dto.SalonDTO;
import com.example.salonCoiffure.entities.Salon;
import com.example.salonCoiffure.service.implService.SalonServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salon")
public class SalonController {
    private final SalonServiceImpl service;

    public SalonController(SalonServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<Salon>> getAll(@PageableDefault(page = 0,size = 5) Pageable pageable){
        Page<Salon> salon=service.getAll(pageable);
        return new ResponseEntity<>(salon, HttpStatus.OK);
    }
    @GetMapping("/filter")
    public ResponseEntity<Page<Salon>> findByMoTCle(@PageableDefault(page = 0,size = 5) Pageable pageable,@RequestParam(required = false) String motCle){
        Page<Salon> salon=service.findByMotCle(pageable, motCle);
        return new ResponseEntity<>(salon, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Void> Create(@RequestBody SalonDTO customersDTO){
        service.add(customersDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SalonDTO> getById(@PathVariable Long id) {
        SalonDTO agentDTO = service.getById(id);
        return new ResponseEntity<>(agentDTO, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody SalonDTO agentDTO){
        SalonDTO agentDTO1=service.getById(id);
        if(!id.equals(agentDTO1.getId())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            service.update(id,agentDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        SalonDTO agentDTO1=service.getById(id);
        if(!id.equals(agentDTO1.getId())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
