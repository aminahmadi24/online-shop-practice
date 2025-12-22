package ir.aminahmadi24;

import ir.aminahmadi24.model.Customer;
import ir.aminahmadi24.repository.CustomerRepository;
import ir.aminahmadi24.service.CustomerService;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer(
                "Amin", "amin@gmail.com", "Asf23@hsk", "Tehran");
        Customer customer2 = new Customer(
                "Reza", "reza@gmail.com", "As2223@hsk", "Shiraz");

        CustomerService customerService = new CustomerService(new CustomerRepository());

        System.out.println("Customer registration: ");
        System.out.println(customerService.signUp(customer1));
        System.out.println(customerService.signUp(customer2));
        System.out.println();

        System.out.println("Customer sign in: ");
        System.out.println(customerService.signIn("amin@gmail.com", "Asf23@hsk"));
        System.out.println();
    }
}
