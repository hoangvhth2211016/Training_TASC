package Thread.Thread;

import java.util.ArrayList;
import java.util.List;

public class CustomThread extends Thread {
    
    private static final List<Integer> list1 = new ArrayList<>(20);
    private static final List<Integer> list2 = new ArrayList<>(20);
    
    private int number;
    
    public CustomThread(int number) {
        this.number = number;
    }
    
    public int getNumber() {
        return number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    
    public static List<Integer> getList1() {
        return list1;
    }
    
    public static List<Integer> getList2() {
        return list2;
    }
    
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            // list1 dc synchronized -> chỉ cho phép 1 thread tác động lên list1 ở cùng 1 thời điểm
            synchronized (list1){
                list1.add(number);
                try {
                    // Phương thức sleep cho phép thread tạm dừng, cho phép các thread khác chạy
                    sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        for(int i = 0; i < 10; i++){
            // list2 ko dc synchronized, nhiều thread có thể cùng lúc tác động lên list2, gây sai sót về dữ liệu
            list2.add(number);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
