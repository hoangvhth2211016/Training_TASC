package Java_Collection.Queue_Interface;

import java.util.*;

public class Main {
    
    
    public static void deque(){
        // Khai báo deque
        Deque<Character> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new LinkedList<>();
        
        // triển khai theo dạng queue.
        deque2.add(1);
        deque2.addLast(2);
        deque2.addLast(3);
        System.out.println("deque2: "+deque2);
        deque2.pollFirst();
        System.out.println("deque2: "+deque2);
        
        // triển khai theo dạng stack
        // push
        deque1.addFirst('a');
        deque1.addFirst('b');
        deque1.addFirst('c');
        System.out.println("deque1: "+deque1);
        // pop
        deque1.pollLast();
        System.out.println("deque1 pop a: "+deque1);
    }
    
    public static void priorityQueue(){
        // Khai báo priority queue
        PriorityQueue<Integer> prio = new PriorityQueue<>();
        prio.add(5);
        prio.add(1);
        prio.add(2);
        prio.add(4);
        System.out.println(prio);
        // phần tử đầu tiên dc sắp xếp lại
        prio.poll();
        System.out.println(prio);
        prio.add(1);
        System.out.println(prio);
    }
    
    public static void main(String [] args){
        priorityQueue();
        //deque();
    }
    
    
}
