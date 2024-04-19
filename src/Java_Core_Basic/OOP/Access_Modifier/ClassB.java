package Java_Core_Basic.OOP.Access_Modifier;

public class ClassB extends ClassA {
    
    
    public ClassB(ClassA a) {
        super(a.var1, a.var2, a.getVar3(), a.var4);
    }
}
