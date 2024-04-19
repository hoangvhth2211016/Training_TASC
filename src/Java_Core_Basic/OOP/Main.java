package Java_Core_Basic.OOP;

public class Main {
    
    public static void main(String [] args){
        Dog d = new Dog("kiki", "white", new Run());
        System.out.println(d.getInfo());
        Fish f = new Fish("sharky", "grey", 5, new Swim());
        System.out.println(f.getInfo());
    }
    
}
