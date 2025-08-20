package com.codewithmosh.store.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RegisterProductRequest {
  private String name;
  private float price;
  private String description;
  private Byte categoryId;
}
