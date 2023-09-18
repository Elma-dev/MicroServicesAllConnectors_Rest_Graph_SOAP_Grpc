package dev.elma.customerservice.web;

import dev.elma.customerservice.entities.Customer;
import dev.elma.customerservice.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerRestConstroler {
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return  customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById( @PathVariable(name = "id")  Long id){
        return customerRepository.findById(id).get();
    }

    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer c){
        return customerRepository.save(c);
    }
}
