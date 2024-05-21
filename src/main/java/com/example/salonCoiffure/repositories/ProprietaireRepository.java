package com.example.salonCoiffure.repositories;

import com.example.salonCoiffure.entities.Proprietaire;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietaireRepository extends JpaRepository<Proprietaire,Long> {
    @Query(value = "SELECT * FROM proprietaire ORDER BY id DESC", nativeQuery = true)
    Page<Proprietaire> findAll(Pageable pageable);

    Page<Proprietaire> findAll(Specification<Proprietaire> spec,Pageable pageable);
}
