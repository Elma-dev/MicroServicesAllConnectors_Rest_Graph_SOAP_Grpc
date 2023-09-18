package dev.elma.customerservice.mappers;

import dev.elma.customerservice.dto.CustomerRequest;
import dev.elma.customerservice.entities.Customer;

public class CustomerMapper {
    public static Customer customerRequestToCustomer(CustomerRequest customerRequest){
        return Customer.builder().name(customerRequest.name()).email(customerRequest.email()).build();
    }
    public static CustomerRequest  customerToCustomerResponse(Customer customer){
        return CustomerRequest.builder().name(customer.getName()).email(customer.getEmail()).build();
    }
}
