package com.dasom.backend_tutoring2.controller;

import com.dasom.backend_tutoring2.dto.ProductReqDTO;
import com.dasom.backend_tutoring2.dto.ProductResDTO;
import com.dasom.backend_tutoring2.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResDTO>> getProductsByName(
            @RequestParam String name,
            @RequestParam int age) {
        return ResponseEntity.ok(productService.getProductsByName(name, age));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResDTO> getProducts(@PathVariable int id) {
        return ResponseEntity.ok(productService.getProducts(id));
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductReqDTO requestDTO) {
        productService.createProduct(requestDTO);
        return ResponseEntity.status(201).body("상품 생성 완료");
    }
}