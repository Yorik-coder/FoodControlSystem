package com.food_system.nutrition.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.food_system.nutrition.dto.CreateProductRequest;
import com.food_system.nutrition.dto.ProductDto;
import com.food_system.nutrition.service.ProductService;

import java.util.List;

import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping
    public List<ProductDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/search")
    public List<ProductDto> findByMinCalories(@RequestParam int minCalories) {
        return service.findByMinCalories(minCalories);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto create(@RequestBody @Valid CreateProductRequest request) {
        return service.create(request);
    }
}
