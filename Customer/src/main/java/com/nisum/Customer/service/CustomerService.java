package com.nisum.Customer.service;

import com.nisum.Customer.model.Customer;
import com.nisum.Customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).orElse(null);
    }

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id , Customer customer){
        if(customerRepository.existsById(id)){
            customer.setCustometId(id);
            return customerRepository.save(customer);
        }
        return null;
    }

    public void deleteCustomerById(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else {
            System.out.println("Customer with " + id + "Does Not Exits");
        }
    }
}
