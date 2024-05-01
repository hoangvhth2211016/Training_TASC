package Assignment_Java_Core.Model;

import Assignment_Java_Core.Exception.ValidationException;

import java.util.regex.Pattern;

public class Customer {
    
    private String name;
    
    private String email;
    
    private String phoneNumber;
    
    public Customer(String name, String email, String phoneNumber) {
            setName(name);
            setEmail(email);
            setPhoneNumber(phoneNumber);
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setName(String name) {
        validateName(name);
        this.name = name;
    }
    
    public void setEmail(String email) throws ValidationException {
        validateEmail(email);
        this.email = email;
    }
    
    public void setPhoneNumber(String phoneNumber) throws ValidationException {
        validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public String toString() {
        return String.format("%s,%s,%s", name, email, phoneNumber);
    }
    
    public static void validateName(String name){
        String NAME_REGEX = "^([A-Za-z][a-z]+[ ]*)+$";
        Pattern pattern = Pattern.compile(NAME_REGEX);
        if(!pattern.matcher(name).matches()) throw new ValidationException("Name invalid");
    }
    
    public static void validateEmail(String email){
        String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        if(!pattern.matcher(email).matches()) throw new ValidationException("Email invalid");
    }
    
    public static void validatePhoneNumber(String phoneNumber){
        String PHONE_REGEX = "^0[0-9]{9}$";
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        if(!pattern.matcher(phoneNumber).matches()) throw new ValidationException("Phone number invalid");
    }
    
}
