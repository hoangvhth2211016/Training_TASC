package Java_Core_Basic.OOP;

public abstract class Animal {
    
    private String name;
    
    private String color;
    
    public Animal(String name, String color) {
        this.name = name;
        this.color = color;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    abstract void sound();
    
    public String getInfo(){
        return "name: "+this.name+"\nColor: "+this.color;
    }
    
}
