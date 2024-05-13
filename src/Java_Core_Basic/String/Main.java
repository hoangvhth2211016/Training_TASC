package Java_Core_Basic.String;

public class Main {
    
    public static void main (String [] args) {
        // String là 1 chuỗi các kí tự
        // Khởi tạo String
        String s1 = "first string";
        String s2 = new String("second String");
        char[] chars = {'3', 'r', 'd', 's', 't', 'r', 'i', 'n', 'g'};
        String s3 = new String(chars);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        
        // nếu khai báo bằng string literal, 2 biến khác nhau sẽ trỏ về cùng 1 vùng nhớ trên String pool
        String s4 = "first string";
        System.out.println("s1:" + System.identityHashCode(s1));
        System.out.println("s4: " + System.identityHashCode(s4));
        
        // string có tính bất biến, không thể thay đổi, việc thay đổi thực chất tạo ra 1 string mới
        String s5 = "5th string";
        System.out.println("s5: " + System.identityHashCode(s5));
        s5 = s5.concat(" new text");
        System.out.println("s5" + System.identityHashCode(s5));
        
        // So sánh String
        String s6 = "hello world";
        String s7 = "world";
        // sử dụng equals/equalsIgnoreCase, trả về true/false
        System.out.println("s6 vs s7: " + s6.equals(s7));
        // Sử dụng compareTo/compareToIgnoreCase, trả về 0 nếu băng nhau, âm nếu
        System.out.println("s6 vs s7: " + s6.compareTo(s7));
        // Sử dụng toán tử == có thể gây sai sót nếu cách thức khởi tạo biến khác nhau
        String s8 = new String("first string");
        System.out.println("s1 == s4: " + (s1 == s4));
        System.out.println("s1 == s8: " + (s1 == s8));
    }
}
