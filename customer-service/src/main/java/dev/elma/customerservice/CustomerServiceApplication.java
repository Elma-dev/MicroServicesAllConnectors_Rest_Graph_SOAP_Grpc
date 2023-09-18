package dev.elma.customerservice;

import dev.elma.customerservice.entities.Customer;
import dev.elma.customerservice.repositories.CustomerRepository;
import org.apache.el.stream.Stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder().name("Abdelljalil").email("abdeljalil@gmail.com").build());
            customerRepository.save(Customer.builder().name("Ahmed").email("Ahmed@gmail.com").build());
            customerRepository.save(Customer.builder().name("Rachid").email("Rachid@gmail.com").build());
        };
    }

}
