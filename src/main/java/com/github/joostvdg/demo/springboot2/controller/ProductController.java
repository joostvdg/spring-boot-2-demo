package com.github.joostvdg.demo.springboot2.controller;

import com.github.joostvdg.demo.springboot2.model.Product;
import com.github.joostvdg.demo.springboot2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(method=RequestMethod.GET, value="/products")
    public Iterable<Product> product() {
        return productRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, value="/products")
    public String save(@RequestBody Product product) {
        productRepository.save(product);

        return product.getId();
    }

    @RequestMapping(method= RequestMethod.GET, value="/products/{id}")
    public Optional<Product> show(@PathVariable String id) {
        return productRepository.findById(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/products/{id}")
    public Product update(@PathVariable String id, @RequestBody Product product) {
        Product prod = productRepository.findById(id).get();
        if(product.getProdName() != null)
            prod.setProdName(product.getProdName());
        if(product.getProdDesc() != null)
            prod.setProdDesc(product.getProdDesc());
        if(product.getProdPrice() != null)
            prod.setProdPrice(product.getProdPrice());
        if(product.getProdImage() != null)
            prod.setProdImage(product.getProdImage());
        productRepository.save(prod);
        return prod;
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/products/{id}")
    public String delete(@PathVariable String id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.get() != null) {
            productRepository.delete(product.get());
        }

        return "product deleted";
    }
}