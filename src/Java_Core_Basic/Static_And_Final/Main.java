package Java_Core_Basic.Static_And_Final;

public class Main {
    public static void main (String [] args){
        Demo demo = new Demo();
        demo.increaseStaticVar(12);
        System.out.println(Demo.getStaticVar());
        System.out.println(demo.getFinalVar1());
        System.out.println(demo.getFinalVar2());
        System.out.println(demo.getStaticFinalVar());
    }
}
