package com.example.salonCoiffure.utils;

import com.example.salonCoiffure.entities.Client;
import com.example.salonCoiffure.entities.Coiffeur;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class CoiffeurSpecification {

    public static Specification<Coiffeur> searchWithKeyword(String keyword) {
        return (root, query, criteriaBuilder) -> {
            if (keyword == null || keyword.isEmpty()) {
                return null;
            }

            String likeKeyword = "%" + keyword + "%";

            return criteriaBuilder.or(
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("nomCoiffeur")), likeKeyword),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("prenomCoiffeur")), likeKeyword),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("cinCoiffeur")), likeKeyword),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("telCoiffeur")), likeKeyword),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("emailCoiffeur")), likeKeyword)
            );
        };
    }
}
