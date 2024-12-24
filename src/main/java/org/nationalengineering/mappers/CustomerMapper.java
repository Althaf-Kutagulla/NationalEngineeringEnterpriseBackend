package org.nationalengineering.mappers;

import org.nationalengineering.entity.Customer;
import org.nationalengineering.records.CustomerRequest;
import org.nationalengineering.records.CustomerResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest customerRequest) {
        return Customer.builder()
                .id(customerRequest.id())
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .phoneNumber(customerRequest.phoneNumber())
                .state(customerRequest.state())
                .town(customerRequest.town())
                .village(customerRequest.village())
                .build();
    }

    public CustomerResponse toCustomerResponse(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getPhoneNumber(),
                customer.getState(),
                customer.getTown(),
                customer.getVillage()
        );
    }
}
