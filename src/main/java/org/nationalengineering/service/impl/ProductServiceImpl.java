package org.nationalengineering.service.impl;

import lombok.RequiredArgsConstructor;
import org.nationalengineering.entity.Product;
import org.nationalengineering.exception.ProductNotFoundException;
import org.nationalengineering.mappers.ProductMapper;
import org.nationalengineering.records.ProductRequest;
import org.nationalengineering.records.ProductResponse;
import org.nationalengineering.repository.ProductRepository;
import org.nationalengineering.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    @Override
    public Integer createProduct(ProductRequest productRequest) {
        //TODO retrieve and add category object to product
        Product savedProduct = productRepository.save(productMapper.toProduct(productRequest));
        return savedProduct.getId();
    }

    @Override
    public ProductResponse getProductById(Integer productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                ()->{return new ProductNotFoundException(String.format("Product Not Found with Id: %d",productId));}
        );
        return productMapper.toProductResponse(product);
    }
    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean updateProduct(ProductRequest productRequest) {
        Product product = productRepository.findById(productRequest.id())
                .orElseThrow(()->{return new ProductNotFoundException(String.format("Product Not Found with Id: %d",productRequest.id()));}
                );
        productMerge(productRequest,product);
        productRepository.save(product);
        return true;
    }

    private void productMerge(ProductRequest productRequest,Product product){
        if(productRequest.name()!=null){
            product.setName(product.getName());
        }
        if(productRequest.quantity()!=null){
            product.setQuantity(productRequest.quantity());
        }
        if(productRequest.price()!=null){
            product.setPrice(productRequest.price());
        }
        if(productRequest.categoryId()!=null){
            //todo retrieve category object and assign it
        }
    }

    @Override
    public Boolean deleteProduct(Integer productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(()->{return new ProductNotFoundException(String.format("Product Not Found with Id: %d",productId));}
                );
        productRepository.delete(product);
        return true;
    }

}
