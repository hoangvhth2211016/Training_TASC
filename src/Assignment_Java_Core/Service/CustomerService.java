package Assignment_Java_Core.Service;

import Assignment_Java_Core.Model.Customer;

import java.util.Map;

public interface CustomerService {
    
    Map<String, Customer> findAll();
    
    Customer findByPhoneNumber(String phoneNumber);
    
    boolean existByPhoneNumber(String phoneNumber);
    
    Customer create(Customer customer);
    
    boolean update(String phoneNumber, Customer customer);
    
    boolean delete(String phoneNumber);
    
    void save();
    
}
