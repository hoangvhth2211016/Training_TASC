package Java_Core_Basic.OOP;

public class Dog extends Animal {
    
    private final int legs = 4;
    
    private Movement movement;
    
    public Dog(String name, String color, Movement movement) {
        super(name, color);
        this.movement = movement;
    }
    
    public int getLegs() {
        return legs;
    }
    
    public Movement getMovement() {
        return movement;
    }
    
    public void setMovement(Movement movement) {
        this.movement = movement;
    }
    
    @Override
    public void sound() {
        System.out.println("woof woof");
    }
    
    @Override
    public String getInfo() {
        return super.getInfo()+"\nNumber of legs: "+this.legs+"\nMovement: "+this.movement.move();
    }
}
