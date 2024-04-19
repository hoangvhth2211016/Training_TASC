package Java_Core_Basic.OOP;

public class Fish extends Animal{
    
    private int fins;
    
    private Movement movement;
    
    public Fish(String name, String color, int fins, Movement movement) {
        super(name, color);
        this.fins = fins;
        this.movement = movement;
    }
    
    public Movement getMovement() {
        return movement;
    }
    
    public void setMovement(Movement movement) {
        this.movement = movement;
    }
    
    public int getFins() {
        return fins;
    }
    
    public void setFins(int fins) {
        this.fins = fins;
    }
    
    @Override
    public void sound() {
        System.out.println("...");
    }
    
    @Override
    public String getInfo() {
        return super.getInfo()+"\nNumber of fins: "+this.fins+"\nMovement: "+this.movement.move();
    }
}
