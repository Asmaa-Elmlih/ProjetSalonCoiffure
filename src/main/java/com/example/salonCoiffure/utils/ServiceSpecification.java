package com.example.salonCoiffure.utils;

import com.example.salonCoiffure.entities.Salon;
import com.example.salonCoiffure.entities.Service;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class ServiceSpecification {
    public static Specification<Service> searchWithKeyword(String keyword) {
        return (root, query, criteriaBuilder) -> {
            if (keyword == null || keyword.isEmpty()) {
                return null;
            }

            String likeKeyword = "%" + keyword + "%";

            return criteriaBuilder.or(
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("nomService")), likeKeyword),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), likeKeyword),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("prixService").as(String.class)), likeKeyword)
            );
        };
    }
}
