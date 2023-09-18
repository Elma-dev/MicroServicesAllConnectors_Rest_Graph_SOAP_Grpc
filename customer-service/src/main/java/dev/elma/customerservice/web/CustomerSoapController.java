package dev.elma.customerservice.web;

import dev.elma.customerservice.dto.CustomerRequest;
import dev.elma.customerservice.entities.Customer;
import dev.elma.customerservice.mappers.CustomerMapper;
import dev.elma.customerservice.repositories.CustomerRepository;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@WebService(name = "CustomerSoapWS")
@AllArgsConstructor
public class CustomerSoapController {
    private CustomerRepository customerRepository;

    @WebMethod
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    @WebMethod
    public Customer getCustomerById(@WebParam(name = "id") Long id){
        return customerRepository.findById(id).get();
    }

    @WebMethod
    public Customer saveCustomer(@WebParam(name = "customer") CustomerRequest customerRequest){
        return customerRepository.save(CustomerMapper.customerRequestToCustomer(customerRequest));
    }

}
