package Java_Collection.Set_Interface;

import java.util.*;

public class Main {
    
    enum Numbers{
        ONE, TWO, THREE, FOUR
    }
    
    public static void main(String[] args){
        
        // Khai báo HashSet
        HashSet<Integer> set = new HashSet<>();
        
        // thêm phần tử
        set.add(1);
        set.add(20);
        set.add(-12);
        set.add(null);
        
        // ko thể thêm phần tử trùng lặp
        set.add(1);
        System.out.println("set: "+set);
        
        // Khai báo EnumSet
        EnumSet<Numbers> enumSet1 = EnumSet.of(Numbers.ONE, Numbers.TWO);
        EnumSet<Numbers> enumSet2 = EnumSet.allOf(Numbers.class);
        System.out.println("EnumSet1: "+enumSet1);
        System.out.println("EnumSet2: "+enumSet2);
        
        // Thêm phần từ
        enumSet1.add(Numbers.FOUR);
        System.out.println("EnumSet1: "+enumSet1);
        
        // Khai báo LinkedHashSet
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("mot");
        linkedHashSet.add("bon");
        linkedHashSet.add("chin");
        System.out.println("Linked Hash Set: "+linkedHashSet);
        
        // Khai báo TreeSet
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(11);
        treeSet.add(1);
        treeSet.add(40);
        System.out.println("treeSet: "+treeSet);
    }
    
}
