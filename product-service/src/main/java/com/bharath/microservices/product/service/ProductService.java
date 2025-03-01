package com.bharath.microservices.product.service;

import com.bharath.microservices.product.dto.ProductRequest;
import com.bharath.microservices.product.dto.ProductResponce;
import com.bharath.microservices.product.model.Product;
import com.bharath.microservices.product.repository.ProductRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Data
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponce createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .skuCode(productRequest.skuCode())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("Product created successfully");
        return new ProductResponce(product.getId(),product.getName(), product.getDescription(), product.getSkuCode(), product.getPrice());
    }

    public List<ProductResponce> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponce(product.getId(),product.getName(), product.getDescription(), product.getSkuCode(), product.getPrice()))
                .toList();
    }
}
