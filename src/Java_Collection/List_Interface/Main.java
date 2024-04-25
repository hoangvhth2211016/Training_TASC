package Java_Collection.List_Interface;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    
    public static void arrayList(){
        
        // Khai báo ArrayList
        List<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>(Set.of(1,2,3));
        
        //Thêm 1 phần tử vào danh sách
        list2.add(4);
        
        // Kiểm tra danh sách có trống ko
        System.out.println("list 1 empty? " + list1.isEmpty());
        
        // Thêm tất cả các phần tử trong collection vào danh sách
        list1.addAll(List.of(1,2,3,4,5,6,7,8,9,5,2));
        System.out.println(list1);
        
        // kiểm tra danh sách
        System.out.println("1 in list1: "+list1.contains(1));
        System.out.println("list2 in list1: "+list1.containsAll(list2));
        
        // So sánh 2 list
        System.out.println("list1 vs list2: " + list1.equals(list2));
        
        // Lấy index
        int indexOf2 = list1.indexOf(2);
        int lastIndexOf2 = list1.lastIndexOf(2);
        System.out.println("first index of 2: " + indexOf2);
        System.out.println("last index of 2: " + lastIndexOf2);
        
        // lấy phần từ tại vị trí chỉ định
        System.out.println("Element at 0: " + list1.get(0));
        
        // set phần tử tại vị trí chỉ định với giá trị mới
        list1.set(10, 10);
        System.out.println("list1: "+list1);
        
        // size của list
        System.out.println("size list1: "+list1.size());
        
        // remove
        list1.remove(10);
        list1.removeAll(list2);
        System.out.println("List1: " + list1);
        
        // sublist
        System.out.println("list2: " + list2);
        System.out.println("sublist of list2: " + list2.subList(0,2));
        
        // clear
        list1.clear();
        System.out.println("lis1 "+ list1);
        
    }
    
    public static void linkedList(){
        
        // Khởi tạo
        LinkedList<Integer> list1 = new LinkedList<>(List.of(1,2,3,4,5,6,1,1,3));
        
        // thêm vào
        list1.addFirst(0);
        list1.addLast(10);
        System.out.println("list1: "+ list1);
        
        // xóa
        list1.removeFirst();
        list1.removeLast();
        System.out.println("list1 remove first and last: "+list1);
        list1.removeFirstOccurrence(1);
        System.out.println("list1 remove first 1: "+list1);
        list1.removeLastOccurrence(3);
        System.out.println("list1 remove last 3: "+list1);
        
        // tìm phần tử với get
        System.out.println("1st: "+list1.getFirst());
        System.out.println("last: "+list1.getLast());
        
        // lấy ra phần tử
        System.out.println("1st: "+list1.pollFirst());
        System.out.println("last: "+list1.pollLast());
        System.out.println("List1: "+ list1);
        
        
    }
    
    public static void stack(){
        // Khởi tạo
        Stack<Integer> stack = new Stack<>();
        // Kiểm tra xem stack có rỗng ko
        System.out.println("stack? "+stack.empty());
        // push thêm phần tử vào đầu danh sách
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("stack: "+stack);
        // pop 1 phần tử ra
        stack.pop();
        System.out.println("Stack: "+stack);
        // xem phần từ trên cùng
        System.out.println("Top: "+stack.peek());
        // tìm kiếm phần tử
        System.out.println("search: "+stack.search(1) );
        
    }
    
    public static void main(String[] args){
        //arrayList();
        //linkedList();
        stack();
    }
    
    
}
