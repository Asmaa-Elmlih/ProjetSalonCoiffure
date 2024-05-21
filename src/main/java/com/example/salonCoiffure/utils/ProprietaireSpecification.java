package com.example.salonCoiffure.utils;

import com.example.salonCoiffure.entities.Client;
import com.example.salonCoiffure.entities.Proprietaire;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class ProprietaireSpecification {
    public static Specification<Proprietaire> searchWithKeyword(String keyword) {
        return (root, query, criteriaBuilder) -> {
            if (keyword == null || keyword.isEmpty()) {
                return null;
            }

            String likeKeyword = "%" + keyword + "%";

            return criteriaBuilder.or(
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("nomProprietaire")), likeKeyword),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("prenomProprietaire")), likeKeyword),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("telProprietaire")), likeKeyword),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("emailProprietaire")), likeKeyword)
            );
        };
    }
}
