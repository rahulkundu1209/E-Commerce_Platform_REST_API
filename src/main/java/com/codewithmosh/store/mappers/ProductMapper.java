package com.codewithmosh.store.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.codewithmosh.store.dtos.ProductDto;
import com.codewithmosh.store.dtos.RegisterProductRequest;
import com.codewithmosh.store.entities.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
  @Mapping(source = "category.id", target="categoryId")
  ProductDto toDto(Product product);
  // @Mapping(source = "categoryId", target="category.id")
  Product toEntity(RegisterProductRequest registerProductRequest);

  void update(RegisterProductRequest request, @MappingTarget Product product);
}
