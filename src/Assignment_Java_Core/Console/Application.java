package Assignment_Java_Core.Console;

import Assignment_Java_Core.Exception.RetryException;
import Assignment_Java_Core.Exception.ValidationException;
import Assignment_Java_Core.Exception.Validator;
import Assignment_Java_Core.Model.Customer;
import Assignment_Java_Core.Service.CustomerService;

import java.util.*;

public class Application {
    
    private final Scanner scanner;
    
    private final CustomerService customerService;
    
    
    private static int counter = 3;
    
    public Application(Scanner scanner, CustomerService customerService){
        this.scanner = scanner;
        this.customerService  = customerService;
    }
    
    public void start(){
        menu();
        try{
            int choice = scanner.nextInt();
            scanner.nextLine();
            handleChoice(choice);
        }catch (InputMismatchException e){
            System.out.println("\nInput invalid, please retry!");
            scanner.nextLine();
            start();
        }catch (RetryException e){
            System.out.println();
            System.out.println(e.getMessage());
            start();
        }
    }
    
    private void handleChoice(int choice){
        switch (choice){
            case 1 -> displayCustomerList();
            case 2 -> createCustomer();
            case 3 -> searchCustomerByPhoneNr();
            case 4 -> editCustomer();
            case 5 -> deleteCustomer();
            case 6 -> {
                System.out.println("\nGoodbye!");
                scanner.close();
                return;
            }
            default -> System.out.println("\nInput invalid, please retry!");
        }
        start();
    }
    
    public void menu(){
        System.out.println();
        System.out.println("1. Customer List");
        System.out.println("2. Add new Customer");
        System.out.println("3. Search by Phone Number");
        System.out.println("4. Edit Customer Information");
        System.out.println("5. Delete Customer");
        System.out.println("6. Close");
        System.out.print("choose: ");
    }
    
    public void customersTable(Collection<Customer> list){
        System.out.println();
        System.out.println("|           Name            |           Email            |      Phone Number     |");
        System.out.println("+---------------------------+----------------------------+-----------------------+");
        list.forEach(e -> System.out.printf("| %-25s | %-26s | %-21s |\n", e.getName(),e.getEmail(),e.getPhoneNumber()));
        System.out.println("+---------------------------+----------------------------+-----------------------+");
    }
    
    public String input(String text, Validator validator){
        System.out.print(text);
        String res = scanner.nextLine().trim();
        if(validator != null){
            try{
                validator.validate(res);
            }catch(ValidationException e){
                System.out.println(e.getMessage());
                if(counter > 0){
                    System.out.println("Please retry! ("+counter+"time(s) left)");
                    counter--;
                    return input(text, validator);
                }else{
                    counter = 3;
                    throw new RetryException("Attempted too many times, returning to menu...");
                }
            }
        }
        return res;
    }
    
    private void displayCustomerList(){
        customersTable(customerService.findAll().values());
    }
    
    private void createCustomer() {
        String name = input("Name: ", Customer::validateName);
        String email = input("Email: ", Customer::validateEmail);
        String phone = input("Phone Number: ", Customer::validatePhoneNumber);
        Customer newCustomer = customerService.create(new Customer(name, email, phone));
        System.out.println();
        System.out.println((newCustomer == null) ? "Customer already exist!" : "A new customer has been created");
    }
    
    private void searchCustomerByPhoneNr() {
        String phone = input("Enter your Phone Number: ", null);
        Customer customer = customerService.findByPhoneNumber(phone);
        System.out.println();
        if(customer == null){
            System.out.println("Customer Not Found!");
        }else{
            System.out.println("Customer:");
            System.out.println("Name: "+customer.getName());
            System.out.println("Email: "+customer.getEmail());
            System.out.println("Phone Number: "+customer.getPhoneNumber());
        }
    }
    
    private void editCustomer() {
        String phone = input("Enter your Phone Number: ", null);
        Customer customer = customerService.findByPhoneNumber(phone);
        if(customer == null){
            System.out.println();
            System.out.println("Customer Not Found!");
            return;
        }
        String updatedName = input("Name ("+customer.getName()+"): ", Customer::validateName);
        String updatedEmail = input("Email ("+customer.getEmail()+"): ", Customer::validateEmail);
        String updatedPhone = input("Phone Number("+customer.getPhoneNumber()+"): ", Customer::validatePhoneNumber);
        customer.setName(updatedName);
        customer.setEmail(updatedEmail);
        customer.setPhoneNumber(updatedPhone);
        boolean edited = customerService.update(phone, customer);
        System.out.println();
        System.out.println(edited? "Your information has been updated!" : "Unable to update Customer!");
    }
    
    private void deleteCustomer() {
        String phone = input("Enter your Phone Number: ", null);
        boolean deleted = customerService.delete(phone);
        System.out.println();
        System.out.println(deleted? "Your account has been deleted!" : "Unable to delete Customer!");
    }
    
}
