package ir.aminahmadi24.repository;

import ir.aminahmadi24.model.Customer;
import ir.aminahmadi24.utility.DynamicArray;

public class CustomerRepository {
    private static final DynamicArray CUSTOMERS_ARRAY = new DynamicArray("Customer");
    public boolean save(Customer customer){
        return CUSTOMERS_ARRAY.add(customer);
    }
    public boolean isEmailDuplicated(String email){
        for (int i = 0; i < CUSTOMERS_ARRAY.getSize(); i++) {
            Customer customer = (Customer)CUSTOMERS_ARRAY.getByIndex(i);
            if(customer.getEmail().equals(email))
                return true;
        }
        return false;
    }
    public int getId(){
        return CUSTOMERS_ARRAY.getSize() + 1;
    }
    public Customer findByEmail(String email){
        for (int i = 0; i < CUSTOMERS_ARRAY.getSize(); i++) {
            Customer c = (Customer) CUSTOMERS_ARRAY.getByIndex(i);
            if(c.getEmail().equals(email))
                return c;
        }
        return null;
    }

    public boolean updateAddress(String email, String newAddress) {
        for (int i = 0; i < CUSTOMERS_ARRAY.getSize(); i++) {
            Customer c = (Customer) CUSTOMERS_ARRAY.getByIndex(i);
            if(c.getEmail().equals(email)){
                c.setAddress(newAddress);
                return true;
            }
        }
        return false;
    }
}
