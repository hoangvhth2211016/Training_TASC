package Java_Core_Basic.OOP.Access_Modifier;

public class ClassA {
    
    // biến public có thể truy cập từ bất cứ đâu trong chương trình
    public int var1;
    
    // có thể truy cập từ bất cứ đâu trong package
    int var2;
    
    // Chỉ có thể truy cập bên trong class
    private int var3;
    
    // Chỉ có thể truy cập bên trong class và các lớp kế thừa
    protected int var4;
    
    public ClassA(int var1, int var2, int var3, int var4) {
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
        this.var4 = var4;
    }
    
    // muốn truy cập tới biến private phải thông qua phương thức public dc định nghĩa trc (getter, setter ...)
    public int getVar3() {
        return var3;
    }
    public void setVar3(int var3) {
        this.var3 = var3;
    }
}
