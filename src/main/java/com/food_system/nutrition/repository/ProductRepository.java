package com.food_system.nutrition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.food_system.nutrition.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
