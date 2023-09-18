package dev.elma.customerservice.web;

import dev.elma.customerservice.dto.CustomerRequest;
import dev.elma.customerservice.entities.Customer;
import dev.elma.customerservice.mappers.CustomerMapper;
import dev.elma.customerservice.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class CustomerGraphqlController {
    private CustomerRepository customerRepository;

    @QueryMapping
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @QueryMapping
    public Customer getCustomerById(@Argument Long id){
        return customerRepository.findById(id).get();
    }

    @MutationMapping
    public Customer saveCustomer(@Argument CustomerRequest customer){
        return customerRepository.save(CustomerMapper.customerRequestToCustomer(customer)); 
    }
}
