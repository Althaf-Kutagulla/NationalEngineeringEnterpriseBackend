package org.nationalengineering.mappers;

import org.nationalengineering.entity.Product;
import org.nationalengineering.records.ProductRequest;
import org.nationalengineering.records.ProductResponse;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toProduct(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.name())
                .quantity(productRequest.quantity())
                .price(productRequest.price())
                .build();
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                null,
                product.getQuantity(),
                product.getPrice()
        );
    }
}
