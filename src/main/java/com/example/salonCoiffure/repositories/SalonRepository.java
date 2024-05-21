package com.example.salonCoiffure.repositories;

import com.example.salonCoiffure.entities.Salon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonRepository extends JpaRepository<Salon,Long> {
    @Query(value = "SELECT * FROM salon ORDER BY id DESC", nativeQuery = true)
    Page<Salon> findAll(Pageable pageable);
    Page<Salon> findAll(Specification<Salon> spec,Pageable pageable);
}
