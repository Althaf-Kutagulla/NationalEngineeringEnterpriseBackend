package org.nationalengineering.mappers;

import org.nationalengineering.entity.Product;
import org.nationalengineering.records.ProductRequest;
import org.nationalengineering.records.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
                product.getCategory().getCategoryId(),
                product.getQuantity(),
                product.getPrice()
        );
    }

    public List<ProductResponse> toProductResponseList(List<Product> productList) {
       return productList.stream()
                .map(product -> {
                    return new ProductResponse(product.getId(),
                            product.getName(),
                            product.getCategory().getCategoryId(),
                            product.getQuantity(),
                            product.getPrice()
                    );
                })
                .collect(Collectors.toList());
    }
}
