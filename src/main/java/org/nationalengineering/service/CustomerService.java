package org.nationalengineering.service;

import org.nationalengineering.records.*;

import java.util.List;

public interface CustomerService {
    /**
    * To create new customer
    * @param customerRequest with all required fields init to create new customer.
    * @return created customer id.
    */
    public Integer createCustomer(CustomerRequest customerRequest);

    /**
     * @param customerRequest with updated fields to update existing customer.
     * @return boolean value to confirm customer updated or not.
     */
    public boolean updateCustomer(CustomerRequest customerRequest);

    /**
     * To get customer details either with fullName or customer id.
     * @param id customer id.
     * @return customerDto with customer details.
     */
    public CustomerResponse getCustomer(Integer id);


    /**
     * To delete customer.
     * @param id customer id.
     * @return boolean to confirm whether customer deleted or not.
     */
    public boolean deleteCustomer(Integer id);

    /**
     * To return all customers
     * @return a list of all customers
     */
    List<CustomerResponse> getAllCustomers();
}
