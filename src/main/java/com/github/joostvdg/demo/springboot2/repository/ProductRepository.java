package com.github.joostvdg.demo.springboot2.repository;

import com.github.joostvdg.demo.springboot2.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, String> {
//    @Override
//    Optional<Product> findById(String id);

    @Override
    void delete(Product deleted);
}