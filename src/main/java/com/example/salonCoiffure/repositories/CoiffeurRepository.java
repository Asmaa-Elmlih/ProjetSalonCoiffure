package com.example.salonCoiffure.repositories;

import com.example.salonCoiffure.entities.Coiffeur;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoiffeurRepository extends JpaRepository<Coiffeur,Long> {
   Page<Coiffeur> findAll( Pageable pageable);
   Page<Coiffeur> findAll(Specification<Coiffeur> spec,Pageable pageable);
}
