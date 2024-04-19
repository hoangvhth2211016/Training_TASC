package Java_Core_Basic.DataType;

import java.util.Arrays;

public class Main {
    public static void main (String[] args){
    
        // kiểu dữ liệu nguyên thủy: là các kiểu dữ liệu có sẵn trong java
        // (byte, short, int, long, float, double, char, boolean)
       
        // Kiểu số nguyên
        byte b = 1; // 1 byte
        short s = 12; // 2 bytes
        int i = 32; // 4 bytes
        long l = 123; // 8 bytes
       
        // Kiểu số thập phân
        float f = 1.1f; // 4 bytes
        double d = 1.1d; // 8 bytes
       
        // Kiểu ký tự
        char c = 'c'; // 2 bytes
      
        // Kiểu boolean
        boolean bool = true; // 1 bit
        
        // Kiểu dữ liệu object: là kiểu dữ liệu được định nghĩa bởi user
        // có thể là array, string, class, interface
        String str = "dsa";
        int[] a = {1,2,3};
        
        // Giá trị khởi tạo của kiểu nguyên thủy phải là giá trị hợp lệ
        int primInit = 0;
        // Giá trị khởi tao của kiểu object có thể là null
        Integer objInit = null;
        
        // Có thể chuyển đổi giữa kiểu dữ liệu nguyên thủy và kiểu object với wrapper class tương ứng
        Integer objInteger = 12;
        int primitiveRef = objInteger;
        System.out.println("object Integer: "+objInteger);
        System.out.println("Primitive reference: "+primitiveRef);
        
        int primInt = 21;
        Integer objRef = primInt;
        System.out.println("primitive int: "+primInt);
        System.out.println("Object reference: "+objRef);
        
        // so sánh:
        // có thể so sánh kiểu dữ nguyên thủy và kiểu object với wrapper class tương ứng
        int num1 = 12;
        Integer num2 = 12;
        System.out.println("num1 vs num2: " + (num1 == num2));
        // trường hợp kiểu dữ liệu object là null, chương trình sẽ throw NullPointerException
        Integer num3 = null;
        try{
            System.out.println("num1 vs num3: " + (num1 == num3));
        }catch(NullPointerException e){
            System.out.println("NullPointerException caught");
        }
        
        // khi copy, biến nguyên thủy tạo ra 2 biến tách biệt
        // và sự thay đổi của 1 biến không ảnh hưởng đến bến còn lại
        int num4 = num1;
        num4 = 13;
        System.out.println("num1: " + num1);
        System.out.println("num4: " + num4);
        // biến object tạo ra 2 biến cùng trỏ về 1 vùng nhớ trong heap,
        // dẫn đến ảnh hưởng của biến này cũng tác đông đến biến kia
        int[] arr1 = {1,2,3,4};
        int [] arr2 = arr1;
        arr2[0] = 5;
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
        
    }
}
