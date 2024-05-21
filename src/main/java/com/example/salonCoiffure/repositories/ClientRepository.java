package com.example.salonCoiffure.repositories;

import com.example.salonCoiffure.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
//    @Query(value = "SELECT * FROM client ORDER BY id DESC", nativeQuery = true)
//    Page<Client> findAll(Specification<Client> spec, Pageable pageable);
    Page<Client> findAll(Specification<Client> spec, Pageable pageable);
}
