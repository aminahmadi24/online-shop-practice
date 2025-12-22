package ir.aminahmadi24.service;

import ir.aminahmadi24.model.Customer;
import ir.aminahmadi24.repository.CustomerRepository;
import ir.aminahmadi24.utility.Validator;

public class CustomerService {
    private final CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    public boolean signUp(Customer customer){
        if(!Validator.isNameValid(customer.getName()))
            return false;
        if(!Validator.isEmailValid(customer.getEmail()))
                return false;
        if(!Validator.isPasswordValid(customer.getPassword()))
            return false;
        if(!Validator.isAddressValid(customer.getAddress()))
            return false;
        if(customerRepository.isEmailDuplicated(customer.getEmail()))
            return false;
        customer.setId(customerRepository.getId());
        return customerRepository.save(customer);
    }
    public boolean signIn(String email, String password){
        Customer customer = customerRepository.findByEmail(email);
        if(customer == null)
            return false;
        return customer.getPassword().equals(password);
    }

}
