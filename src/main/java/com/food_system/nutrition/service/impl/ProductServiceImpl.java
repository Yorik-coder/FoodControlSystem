package com.food_system.nutrition.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.food_system.nutrition.dto.CreateProductRequest;
import com.food_system.nutrition.dto.ProductDto;
import com.food_system.nutrition.entity.Product;
import com.food_system.nutrition.mapper.ProductMapper;
import com.food_system.nutrition.repository.ProductRepository;
import com.food_system.nutrition.service.ProductService;
import com.food_system.nutrition.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Override
    public List<ProductDto> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getById(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found"));
        return mapper.toDto(product);
    }

    @Override
    public List<ProductDto> findByMinCalories(int minCalories) {
        return repository.findAll()
                .stream()
                .filter(p -> p.getCalories() >= minCalories)
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto create(CreateProductRequest request) {

     Product product = Product.builder()
        .name(request.getName())
        .calories(request.getCalories())
        .protein(request.getProtein())
        .fat(request.getFat())
        .carbs(request.getCarbs())
        .build();

        Product saved = repository.save(product);

        return mapper.toDto(saved);
    }
}
