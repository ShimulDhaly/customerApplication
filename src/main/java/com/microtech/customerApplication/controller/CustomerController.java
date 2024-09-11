package com.microtech.customerApplication.controller;

import com.microtech.customerApplication.entity.Customer;
import com.microtech.customerApplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cust")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/insertcust")
    public ResponseEntity<String> insertCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return new ResponseEntity<>("customer added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/allcust")
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Integer id) {
        Customer customer = customerRepository.findById(id).orElse(null);

        if (customer != null) {
            return ResponseEntity.ok(customer);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id, @RequestBody Customer updateCustomer) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            customer.setName(updateCustomer.getName());
            customer.setAddress(updateCustomer.getAddress());
            customer.setEmail(updateCustomer.getEmail());
            customer.setSalary(updateCustomer.getSalary());
            customerRepository.save(customer);
            return ResponseEntity.ok(customer);
        }else {
            return ResponseEntity.notFound().build();
        }
    }




        @DeleteMapping("/{id}")
                public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id){
            if (customerRepository.existsById(id)){
                customerRepository.deleteById(id);
                return ResponseEntity.noContent().build();

            }else {
                return ResponseEntity.notFound().build();

        }
    }
    @DeleteMapping("/deleteall")
    public ResponseEntity<Void>deleteAllCustomer(){
        customerRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
