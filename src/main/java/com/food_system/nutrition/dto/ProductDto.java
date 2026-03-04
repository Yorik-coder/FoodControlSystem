package com.food_system.nutrition.dto;

public class ProductDto {

    private Long id;
    private String name;
    private int calories;

    public ProductDto(Long id, String name, int calories) {
        this.id = id;
        this.name = name;
        this.calories = calories;
    }

    // getters
    public int getCalories() {
        return calories;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
