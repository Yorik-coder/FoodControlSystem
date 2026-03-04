package com.food_system.nutrition.service;

import com.food_system.nutrition.dto.CreateProductRequest;
import com.food_system.nutrition.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAll();

    ProductDto getById(Long id);

    List<ProductDto> findByMinCalories(int minCalories);

    ProductDto create(CreateProductRequest request);
}
