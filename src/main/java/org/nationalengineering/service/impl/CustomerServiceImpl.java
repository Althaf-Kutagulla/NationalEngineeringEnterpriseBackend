package org.nationalengineering.service.impl;

import lombok.RequiredArgsConstructor;
import org.nationalengineering.entity.Customer;
import org.nationalengineering.exception.CustomerNotFoundException;
import org.nationalengineering.mappers.CustomerMapper;
import org.nationalengineering.repository.CustomerRepository;
import org.nationalengineering.service.CustomerService;
import org.nationalengineering.records.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public Integer createCustomer(CustomerRequest customerRequest) {
        return customerRepository.save(customerMapper.toCustomer(customerRequest)).getId();
    }

    @Override
    public CustomerResponse getCustomer(Integer id) {
        Customer customer = customerRepository.findById(id) .orElseThrow(
                ()->new CustomerNotFoundException(String.format("Customer not found with Id: %d",id)
                ));
        return customerMapper.toCustomerResponse(customer);
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customerMapper::toCustomerResponse)
                .collect(Collectors.toList());
    }

    @Override
    public boolean updateCustomer(CustomerRequest customerRequest) {
        Customer customer = customerRepository.findById(customerRequest.id())
                .orElseThrow(
                        ()->new CustomerNotFoundException(String.format("Customer not found with Id: %d",customerRequest.id()))
                );
        Customer updatedCustomer = customerRepository.save(customerMapper.toCustomer(customerRequest));
        return true;
    }

    @Override
    public boolean deleteCustomer(Integer id) {
        Customer customer = customerRepository.findById(id) .orElseThrow(
                ()->new CustomerNotFoundException(String.format("Customer not found with Id: %d",id)
                ));
        customerRepository.deleteById(id);
        return true;
    }


}
