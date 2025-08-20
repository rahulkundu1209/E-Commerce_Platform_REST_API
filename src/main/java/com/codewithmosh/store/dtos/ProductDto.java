package com.codewithmosh.store.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductDto {
  private long id;
  private String name;
  private float price;
  private String description;
  private Byte categoryId;
}
