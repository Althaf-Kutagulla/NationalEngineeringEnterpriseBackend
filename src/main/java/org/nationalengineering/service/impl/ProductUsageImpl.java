package org.nationalengineering.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.nationalengineering.entity.MotorTicket;
import org.nationalengineering.entity.Product;
import org.nationalengineering.entity.ProductUsage;
import org.nationalengineering.exception.MotorTicketNotFoundException;
import org.nationalengineering.exception.ProductException;
import org.nationalengineering.exception.ProductNotFoundException;
import org.nationalengineering.exception.ProductUsageNotFoundException;
import org.nationalengineering.mappers.ProductUsageMapper;
import org.nationalengineering.records.ProductUsageRequest;
import org.nationalengineering.records.ProductUsageResponse;
import org.nationalengineering.repository.CustomerRepository;
import org.nationalengineering.repository.MotorTicketRepository;
import org.nationalengineering.repository.ProductRepository;
import org.nationalengineering.repository.ProductUsageRepositoty;
import org.nationalengineering.service.ProductUsageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductUsageImpl implements ProductUsageService {

    private final ProductUsageRepositoty productUsageRepositoty;
    private final CustomerRepository CustomerRepository;
    private final ProductRepository productRepository;
    private final MotorTicketRepository motorTicketRepository;
    private final ProductUsageMapper productUsageMapper;


    @Override
    public ProductUsageResponse getProductUsage(Integer id) {
        return productUsageMapper.toProductUsageResponse(productUsageRepositoty.findById(id).orElseThrow(
                ()-> new ProductUsageNotFoundException("ProductUsage Not Found with id " + id)
        ));
    }

    @Override
    public List<ProductUsageResponse> getAllProductUsages() {
        return productUsageRepositoty.findAll().stream()
                .map(productUsageMapper::toProductUsageResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean createProductUsage(ProductUsageRequest productUsageRequest) {
        MotorTicket motorTicket = motorTicketRepository.findById(productUsageRequest.motorTicketId())
                .orElseThrow(()-> new MotorTicketNotFoundException("MotorTicket Not Found with id " + productUsageRequest.motorTicketId()));
        Product product = productRepository.findById(productUsageRequest.productId())
                .orElseThrow(()-> new ProductNotFoundException("Product Not Found with id " + productUsageRequest.productId()));
        List<Integer> productIds = productUsageRepositoty.findByMotorTicketId(productUsageRequest.motorTicketId())
                .stream().map((productUsage -> {
                    return productUsage.getProduct().getId();
                })).toList();
        if(productIds.contains(productUsageRequest.productId())){
            throw new ProductException("Product with id "+productUsageRequest.productId()+" already associated with id " + productUsageRequest.motorTicketId());
        }

        if(productUsageRequest.quantityUsed() > product.getQuantity()){
            throw new ProductException("Insufficient quantity product id:"+product.getId());
        }
        ProductUsage productUsage = productUsageMapper.toProductUsage(productUsageRequest);
        productUsage.setMotorTicket(motorTicket);
        productUsage.setProduct(product);
        productUsageRepositoty.save(productUsage);
        product.setQuantity(product.getQuantity() - productUsage.getQuantityUsed());
        productRepository.save(product);
        return true;
    }

    @Override
    public Boolean updateProductUsage(ProductUsageRequest productUsageRequest) {
        ProductUsage productUsage = productUsageRepositoty.findById(productUsageRequest.id())
                .orElseThrow(()-> new ProductUsageNotFoundException("Product Usage Not Found with id " + productUsageRequest.id()));
        MotorTicket motorTicket = motorTicketRepository.findById(productUsageRequest.motorTicketId())
                .orElseThrow(()-> new MotorTicketNotFoundException("MotorTicket Not Found with id " + productUsageRequest.motorTicketId()));
        Product product = productRepository.findById(productUsageRequest.productId())
                .orElseThrow(()-> new ProductNotFoundException("Product Not Found with id " + productUsageRequest.productId()));
        if(productUsageRequest.quantityUsed() > productUsage.getQuantityUsed()){
            Integer newQuantity = productUsageRequest.quantityUsed() - productUsage.getQuantityUsed();
            if(newQuantity > product.getQuantity()){
                throw new ProductException("Insufficient quantity product id:"+product.getId());
            }
            product.setQuantity(product.getQuantity() - newQuantity);
            productRepository.save(product);
            productUsage.setQuantityUsed(productUsageRequest.quantityUsed());
        } else if (productUsageRequest.quantityUsed() < productUsage.getQuantityUsed()) {
            Integer newQuantity = productUsage.getQuantityUsed() - productUsageRequest.quantityUsed();
            product.setQuantity(product.getQuantity() + newQuantity);
            productRepository.save(product);
            productUsage.setQuantityUsed(productUsageRequest.quantityUsed());
        }
        productUsageRepositoty.save(productUsage);
        return true;
    }

    @Override
    public Boolean delete(Integer id) {
        ProductUsage productUsage = productUsageRepositoty.findById(id).orElseThrow(
                ()-> new ProductUsageNotFoundException("Product Usage Not Found with id " + id)
        );
        MotorTicket motorTicket = motorTicketRepository.findById(productUsage.getMotorTicket().getId())
                        .orElseThrow(()-> new MotorTicketNotFoundException("MotorTicket Not Found with id " + productUsage.getMotorTicket().getId()));
        motorTicket.getProductUsageList().remove(productUsage);
        motorTicketRepository.save(motorTicket);
        productUsageRepositoty.delete(productUsage);
        return true;
    }
}
