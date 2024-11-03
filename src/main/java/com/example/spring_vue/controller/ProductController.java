package com.example.spring_vue.controller;

import com.example.spring_vue.model.Product;
import com.example.spring_vue.model.Tutorial;
import com.example.spring_vue.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    //    @Autowired
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }
//
//    @GetMapping("/products")
//    public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false) String title) {
//        try {
//            List<Product> products = new ArrayList<Product>();
//
//            if (title == null)
//                tutorialRepository.findAll().forEach(tutorials::add);
//            else
//                tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);
//
//            if (tutorials.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//            return new ResponseEntity<>(tutorials, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//
//    @PostMapping("/products")
//    public Product saveProduct(@RequestBody Product product) {
//        return productService.saveProduct(product);
//    }

    @PostMapping("/products")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        try {
            Product _product = productRepository
                    .save(new Product(product.getName(), product.getPrice()));
            return new ResponseEntity<>(_product, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/{id}")
//    public Product getProductById(@PathVariable Long id) {
//        return productService.getProductById(id);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteProduct(@PathVariable Long id) {
//        productService.deleteProduct(id);
//    }
}