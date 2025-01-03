package org.nationalengineering.service.impl;

import lombok.RequiredArgsConstructor;
import org.nationalengineering.entity.*;
import org.nationalengineering.exception.*;
import org.nationalengineering.mappers.*;
import org.nationalengineering.records.*;
import org.nationalengineering.repository.*;
import org.nationalengineering.service.MotorTicketService;
import org.nationalengineering.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MotorTicketServiceImpl implements MotorTicketService {

    private final MotorTicketRepository motorTicketRepository;
    private final CustomerRepository customerRepository;
    private final MotorRepository motorRepository;
    private final ProductRepository productRepository;
    private final ProductUsageRepositoty productUsageRepositoty;
    private final MotorTicketMapper motorTicketMapper;
    private final CustomerMapper customerMapper;
    private final MotorMapper motorMapper;
    private final ProductService productService;
    private final ProductMapper productMapper;
    private final ProductUsageMapper productUsageMapper;


    @Override
    public Integer createMotorTicket(MotorTicketRequest motorTicketRequest) {
        Customer customer = customerRepository.findById(motorTicketRequest.customerId())
                .orElseThrow(()->new CustomerNotFoundException("Customer not found with id:"+motorTicketRequest.customerId()));
        Motor motor = motorRepository.findById(motorTicketRequest.motorId())
                .orElseThrow(()->new MotorNotFoundException("Motor not found with id:"+motorTicketRequest.motorId()));

        MotorTicket motorTicket = motorTicketMapper.toMotorTicket(motorTicketRequest);
        motorTicket.setCustomer(customer);
        motorTicket.setMotor(motor);
        motorTicket.setDescription(motorTicketRequest.description());
        motorTicket.setMotorTicketStatus(motorTicketRequest.motorTicketStatus());
        MotorTicket savedMotorTicket = motorTicketRepository.save(motorTicket);
        return savedMotorTicket.getId();
    }

    @Override
    public Boolean updateMotorTicket(MotorTicketRequest motorTicketRequest) {
        MotorTicket motorTicket = motorTicketRepository.findById(motorTicketRequest.id())
                .orElseThrow(()-> new MotorTicketNotFoundException("MotorTicket not found with id:"+motorTicketRequest.id()));

        if(motorTicketRequest.customerId() != motorTicket.getCustomer().getId()) {
            Customer customer = customerRepository.findById(motorTicketRequest.customerId())
                    .orElseThrow(()-> new CustomerNotFoundException("Customer not found with id:"+motorTicketRequest.customerId()));
            motorTicket.setCustomer(customer);
        }
        if(motorTicketRequest.motorId() != motorTicket.getMotor().getId()) {
            Motor motor = motorRepository.findById(motorTicketRequest.motorId())
                    .orElseThrow(()-> new MotorNotFoundException("Motor not found with id:"+motorTicketRequest.motorId()));
            motorTicket.setMotor(motor);
        }
        if(!motorTicketRequest.description().equals(motorTicket.getDescription())){
            motorTicket.setDescription(motorTicketRequest.description());
        }
        if(motorTicketRequest.motorTicketStatus() != motorTicket.getMotorTicketStatus()) {
            motorTicket.setMotorTicketStatus(motorTicketRequest.motorTicketStatus());
        }
        motorTicketRepository.save(motorTicket);
        return true;
    }

    @Override
    public Boolean deleteMotorTicket(Integer motorTicketId) {
        motorTicketRepository.findById(motorTicketId).orElseThrow(
                ()-> new MotorTicketNotFoundException("MotorTicket not found with id:"+motorTicketId)
        );
        motorTicketRepository.deleteById(motorTicketId);
        return true;
    }

    @Override
    public MotorTicketResponse getMotorTicketById(Integer motorTicketId) {
        MotorTicket motorTicket = motorTicketRepository.findById(motorTicketId)
                .orElseThrow(()-> new MotorTicketNotFoundException("MotorTicket not found with id:"+motorTicketId));

        List<ProductUsageResponse> productUsageResponses = motorTicket.getProductUsageList().stream()
                .map((productUsageMapper::toProductUsageResponse))
                .toList();
        return new MotorTicketResponse(motorTicket.getId(),
                customerMapper.toCustomerResponse(motorTicket.getCustomer()),
                motorMapper.toMotorResponse(motorTicket.getMotor()),
                productUsageResponses,
                motorTicket.getDescription(),
                motorTicket.getMotorTicketStatus()
                );
    }

    @Override
    public List<MotorTicketResponse> getAllMotorTickets() {
        List<MotorTicket> motorTickets = motorTicketRepository.findAll();
       return motorTickets.stream()
                .map((motorTicket -> {
                    CustomerResponse customerResponse = customerMapper.toCustomerResponse(motorTicket.getCustomer());
                    MotorResponse motorResponse = motorMapper.toMotorResponse(motorTicket.getMotor());

                    List<ProductUsageResponse> productUsageResponses = motorTicket.getProductUsageList().stream()
                            .map((productUsageMapper::toProductUsageResponse))
                            .toList();
                    return new MotorTicketResponse(motorTicket.getId(),customerResponse,motorResponse,productUsageResponses,motorTicket.getDescription(),motorTicket.getMotorTicketStatus());
                })).toList();
    }


//     motorTicketRequest.productUsageRequestList().forEach(productUsageRequest->{
//        Product product = productRepository.findById(productUsageRequest.productId())
//                .orElseThrow(()->new ProductNotFoundException("Product not found with id:"+productUsageRequest.productId()));
//        if(product.getQuantity() < productUsageRequest.quantityUsed())
//            throw new ProductNotFoundException("Insufficient quantity for product :"+productUsageRequest.productId());
//        ProductUsage productUsage = ProductUsage.builder()
//                .product(product)
//                .motorTicket(savedMotorTicket)
//                .quantityUsed(productUsageRequest.quantityUsed())
//                .build();
//    });
}
