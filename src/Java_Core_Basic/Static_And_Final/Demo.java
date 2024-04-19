package Java_Core_Basic.Static_And_Final;

public class Demo {
    
    // Biến dc khai báo với final có giá trị khởi tạo
    private final int finalVar1 = 10;
    
    // Biến dc khai báo với final nhưng ko có giá trị khởi tạo cần dc khởi tạo trong constructor
    private final int finalVar2;
    
    // Biến dc khai báo với static
    private static int staticVar = 10;
    
    // Biến dc khai báo với static final ko có giá trị khởi tạo cần dc khởi tạo trong khối static
    private static final int staticFinalVar;
    
    static{
        staticFinalVar = 1;
    }
    
    // Constructor
    public Demo(){
        // Khởi tạo finalVar2 trong constructor
        finalVar2 = 1000;
    }
    
    // Phương thức static có thể tương tác với biến static
    public static int getStaticVar(){
        return staticVar;
    }
    
    // Biến static có thể thay đổi thông qua phương thức của instance
    public void increaseStaticVar(int plus){
        staticVar += plus;
    }
    
    public int getFinalVar1(){
        return finalVar1;
    }
    
    public int getFinalVar2(){
        return finalVar2;
    }
    
    public int getStaticFinalVar(){
        return staticFinalVar;
    }
    
}
