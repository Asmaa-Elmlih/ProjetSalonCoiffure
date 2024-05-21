package com.example.salonCoiffure.repositories;

import com.example.salonCoiffure.entities.Salon;
import com.example.salonCoiffure.entities.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Long> {
    @Query(value = "SELECT * FROM service ORDER BY id DESC", nativeQuery = true)
    Page<Service> findAll(Pageable pageable);
    Page<Service> findAll(Specification<Service> spec, Pageable pageable);
}
