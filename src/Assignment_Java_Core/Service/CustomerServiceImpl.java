package Assignment_Java_Core.Service;

import Assignment_Java_Core.FileHandler.FileHandler;
import Assignment_Java_Core.Model.Customer;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomerServiceImpl implements CustomerService {
    
    private static final Map<String, Customer> customers = new ConcurrentHashMap<>();
    
    private final FileHandler fileHandler;
    
    public CustomerServiceImpl(FileHandler fileHandler){
        this.fileHandler = fileHandler;
        findAll();
    }
    
    @Override
    public Map<String, Customer> findAll() {
        if(customers.isEmpty()){
            List<String[]> list = fileHandler.read();
            list.forEach(e ->{
                customers.put(e[2], new Customer(e[0], e[1], e[2]));
            });
        }
        return customers;
    }
    
    @Override
    public Customer findByPhoneNumber(String phoneNumber) {
        return customers.get(phoneNumber);
    }
    
    @Override
    public boolean existByPhoneNumber(String phoneNumber) {
        return customers.containsKey(phoneNumber);
    }
    
    @Override
    public Customer create(Customer customer) {
        if(existByPhoneNumber(customer.getPhoneNumber())){
            return null;
        }
        customers.put(customer.getPhoneNumber(), customer);
        save();
        return customer;
    }
    
    @Override
    public boolean update(String phoneNumber, Customer customer) {
        if(existByPhoneNumber(phoneNumber)){
            if(customer.getPhoneNumber().equals(phoneNumber)) customers.remove(phoneNumber);
            customers.put(customer.getPhoneNumber(), customer);
            save();
            return true;
        }
        return false;
    }
    
    @Override
    public boolean delete(String phoneNumber) {
        if(existByPhoneNumber(phoneNumber)){
            customers.remove(phoneNumber);
            save();
            return true;
        }
        return false;
    }
    
    @Override
    public void save() {
        fileHandler.write(convertToStringList());
        customers.clear();
        findAll();
    }
    
    
    private List<String> convertToStringList(){
        return customers.values().stream().map(Customer::toString).toList();
    }
}
