package com.food_system.nutrition.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CreateProductRequest {

    @NotBlank
    private String name;

    @Min(0)
    private int calories;

    @Min(0)
    private double protein;

    @Min(0)
    private double fat;

    @Min(0)
    private double carbs;

    // getters & setters
    public int getCalories() {
        return calories;
    }
    public double getCarbs() {
        return carbs;
    }
    public double getFat() {
        return fat;
    }
    public String getName() {
        return name;
    }
    public double getProtein() {
        return protein;
    }
}
