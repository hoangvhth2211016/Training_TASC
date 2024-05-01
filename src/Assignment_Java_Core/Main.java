package Assignment_Java_Core;

import Assignment_Java_Core.Console.Application;
import Assignment_Java_Core.FileHandler.CsvHandler;
import Assignment_Java_Core.FileHandler.FileHandler;
import Assignment_Java_Core.Service.CustomerService;
import Assignment_Java_Core.Service.CustomerServiceImpl;

import java.util.Scanner;


public class Main {
    
    public static void main(String[] args) {
        
        String FILE_PATH = "src/Assignment_Java_Core/Customers.csv";
        
        Scanner scanner = new Scanner(System.in);
        
        FileHandler fileHandler = new CsvHandler(FILE_PATH);
        
        CustomerService customerService = new CustomerServiceImpl(fileHandler);
        
        Application app = new Application(scanner, customerService);
        
        app.start();
        
    }
}
