package com.food_system.nutrition.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.food_system.nutrition.dto.ProductDto;
import com.food_system.nutrition.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto toDto(Product product);

    Product toEntity(ProductDto dto);
}
