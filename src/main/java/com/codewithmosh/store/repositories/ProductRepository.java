package com.codewithmosh.store.repositories;

import com.codewithmosh.store.entities.Product;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findByCategoryId(Byte categoryId);

  @EntityGraph(attributePaths = "category")
  @Query("SELECT p FROM Product p")
  List<Product> findAllWithCategory();
}