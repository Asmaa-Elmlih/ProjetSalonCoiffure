package com.example.salonCoiffure.utils;

import com.example.salonCoiffure.entities.Proprietaire;
import com.example.salonCoiffure.entities.Salon;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class SalonSpecification {
    public static Specification<Salon> searchWithKeyword(String keyword) {
        return (root, query, criteriaBuilder) -> {
            if (keyword == null || keyword.isEmpty()) {
                return null;
            }

            String likeKeyword = "%" + keyword + "%";

            return criteriaBuilder.or(
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("nomSalon")), likeKeyword),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("addresse")), likeKeyword)
            );
        };
    }
}
