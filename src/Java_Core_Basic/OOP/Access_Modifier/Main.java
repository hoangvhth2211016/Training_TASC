package Java_Core_Basic.OOP.Access_Modifier;

public class Main {
    public static void main(String [] args){
        ClassA a = new ClassA(1,2,3,4);
        System.out.println(a.var1);
        System.out.println(a.var2);
        System.out.println(a.getVar3());
        System.out.println(a.var4);
        ClassB b = new ClassB(a);
        System.out.println(b.var4);
    }
}
