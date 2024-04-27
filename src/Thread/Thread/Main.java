package Thread.Thread;

import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        
        // Sử dụng lớp Thread
        CustomThread ct1 = new CustomThread(1);
        CustomThread ct2 = new CustomThread(2);
        
        ct1.start();
        ct2.start();
        ct1.join();
        ct2.join();
        System.out.println("List1: "+CustomThread.getList1());
        System.out.println("List1 size: "+CustomThread.getList1().size());
        System.out.println("List2: "+CustomThread.getList2());
        System.out.println("List2 size: "+CustomThread.getList2().size());
        
        // Sử dụng interface Runnable
        List<Integer> list3 = new ArrayList<>();
        Thread t1 = new Thread(new CustomRunnable(list3, 7));
        Thread t2 = new Thread(new CustomRunnable(list3, 9));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("List3: "+list3);
        System.out.println("List3 size: "+list3.size());
        
        // Sử dụng callback
        Thread cb = new Thread(() -> {
            System.out.println("Thread with callback function");
        });
        
    }
    
    
}
