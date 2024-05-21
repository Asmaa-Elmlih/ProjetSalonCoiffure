package com.example.salonCoiffure.utils;


import com.example.salonCoiffure.entities.Client;
import com.example.salonCoiffure.repositories.ClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ClientSpecification {

public static Specification<Client> searchWithKeyword(String keyword) {
    return (root, query, criteriaBuilder) -> {
        if (keyword == null || keyword.isEmpty()) {
            return null;
        }

        String likeKeyword = "%" + keyword + "%";

        return criteriaBuilder.or(
                criteriaBuilder.like(criteriaBuilder.lower(root.get("nomClient")), likeKeyword),
                criteriaBuilder.like(criteriaBuilder.lower(root.get("prenomClient")), likeKeyword),
                criteriaBuilder.like(criteriaBuilder.lower(root.get("emailClient")), likeKeyword),
                criteriaBuilder.like(criteriaBuilder.lower(root.get("cinClient")), likeKeyword),
                criteriaBuilder.like(criteriaBuilder.lower(root.get("telClient")), likeKeyword)
        );
    };
}


}
