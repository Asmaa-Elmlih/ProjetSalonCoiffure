package com.example.salonCoiffure.controllers;

import com.example.salonCoiffure.dto.SalonDTO;
import com.example.salonCoiffure.dto.ServiceDTO;
import com.example.salonCoiffure.entities.Service;
import com.example.salonCoiffure.service.implService.ServiceServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {
    private final ServiceServiceImpl service;

    public ServiceController(ServiceServiceImpl service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<Page<Service>> getAll(@PageableDefault(page = 0,size = 5)Pageable pageable){
        Page<Service> servicePage=service.getAll(pageable);
        return new ResponseEntity<>(servicePage, HttpStatus.OK);
    }
    @GetMapping("/filter")
    public ResponseEntity<Page<Service>> findByMotCle(@PageableDefault(page = 0,size = 5)Pageable pageable,@RequestParam(required = false) String motCle){
        Page<Service> servicePage=service.getAll(pageable);
        return new ResponseEntity<>(servicePage, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Void> Create(@RequestBody ServiceDTO customersDTO){
        service.add(customersDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ServiceDTO> getById(@PathVariable Long id) {
        ServiceDTO agentDTO = service.getById(id);
        return new ResponseEntity<>(agentDTO, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody ServiceDTO agentDTO){
        ServiceDTO agentDTO1=service.getById(id);
        if(!id.equals(agentDTO1.getId())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            service.update(id,agentDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        ServiceDTO agentDTO1=service.getById(id);
        if(!id.equals(agentDTO1.getId())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
