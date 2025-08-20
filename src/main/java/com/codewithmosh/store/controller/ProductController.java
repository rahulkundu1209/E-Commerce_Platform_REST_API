package com.codewithmosh.store.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.codewithmosh.store.dtos.ProductDto;
import com.codewithmosh.store.dtos.RegisterProductRequest;
import com.codewithmosh.store.entities.Product;
import com.codewithmosh.store.mappers.ProductMapper;
import com.codewithmosh.store.repositories.CategoryRepository;
import com.codewithmosh.store.repositories.ProductRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
  private final ProductRepository productRepository;
  private final ProductMapper productMapper;
  private final CategoryRepository categoryRepository;

  @GetMapping
  public List<ProductDto> getAllProducts(@RequestParam(name = "categoryId", required = false) Byte categoryId){
    System.out.println("Inside getAllProducts");
    List<Product> products;
    if(categoryId != null){
      products = productRepository.findByCategoryId(categoryId);
    }else{
      products = productRepository.findAllWithCategory();
    }

    return products
      .stream()
      .map(productMapper::toDto)
      .toList();
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductDto> getProductById(@PathVariable long id){
    Product product = productRepository.findById(id).orElse(null);

    if(product == null){
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(productMapper.toDto(product));
  }

  @PostMapping
  public ResponseEntity<ProductDto> createNewProduct(
    @RequestBody RegisterProductRequest request,
    UriComponentsBuilder uriBuilder
  ){
    var category = categoryRepository.findById(request.getCategoryId()).orElse(null);
    if(category == null){
      return ResponseEntity.badRequest().build();
    }

    var product = productMapper.toEntity(request);
    product.setCategory(category);
    productRepository.save(product);

    ProductDto productDto = productMapper.toDto(product);
    var uri = uriBuilder.path("/products/{id}").buildAndExpand(productDto.getId()).toUri();

    return ResponseEntity.created(uri).body(productDto);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProductDto> updateProduct(
    @PathVariable Long id,
    @RequestBody RegisterProductRequest request
  ){
    var product = productRepository.findById(id).orElse(null);
    if(product == null){
      return ResponseEntity.notFound().build();
    }

    var category = categoryRepository.findById(request.getCategoryId()).orElse(null);
    if(category == null){
      return ResponseEntity.badRequest().build();
    }

    productMapper.update(request, product);
    product.setCategory(category);
    productRepository.save(product);

    return ResponseEntity.ok(productMapper.toDto(product));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProduct(
    @PathVariable Long id
  ){
    var product = productRepository.findById(id).orElse(null);
    if(product == null){
      return ResponseEntity.notFound().build();
    }

    productRepository.deleteById(id);

    return ResponseEntity.noContent().build();
  }
}
