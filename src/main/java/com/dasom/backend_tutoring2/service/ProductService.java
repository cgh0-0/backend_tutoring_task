package com.dasom.backend_tutoring2.service;

import com.dasom.backend_tutoring2.dto.ProductReqDTO;
import com.dasom.backend_tutoring2.dto.ProductResDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    public List<ProductResDTO> getProductsByName(String name, int age) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 필수입니다.");
        }

        List<ProductResDTO> result = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            int price = i * 1000;
            String grade = price <= 2000 ? "싼" : price <= 4000 ? "보통" : "비싼";
            String productName = name + " " + age + "세에겐 " + grade + " 상품" + i;
            result.add(new ProductResDTO(i, productName, price));
        }
        return result;
    }

    public ProductResDTO getProducts(int id) {
        if (id < 1 || id > 100) {
            throw new RuntimeException("상품 없음");
        }
        return new ProductResDTO(id, "상품" + id, id * 1000);
    }

    public void createProduct(ProductReqDTO requestDTO) {
        String name = requestDTO.getName().trim();
        int price = requestDTO.getPrice();

        String grade = switch (price / 30000) {
            case 0 -> "저가";
            case 1 -> "중가";
            default -> "고가";
        };

        String formattedName = String.join("-", name.split(""));
        System.out.println("생성된 상품: " + formattedName + " / " + grade);
    }
}