package Java_Collection.Map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    
    public static void main(String[] args){
        // Khởi tạo
        HashMap<String, Integer> map = new HashMap<>();
        
        // Thêm phần tử
        map.put("first", 1);
        map.putAll(Map.of("second",2,"third",3));
        System.out.println(map.entrySet());
        
        // Tìm phần tử
        System.out.println("first: "+map.get("first"));
        System.out.println("forth(default = 0): "+map.getOrDefault("forth",0));
        System.out.println("contain key first: "+map.containsKey("first"));
        System.out.println("contain value 100:"+map.containsValue(100));
        
        // Thay thế giá trị
        map.replace("forth",4);
        System.out.println(map.entrySet());
        boolean a = map.replace("first", 1, 10);
        if(a) System.out.println(map);
        
        // xóa key và value
        System.out.println(map.remove("forth"));
        System.out.println("remove first: "+(map.remove("first", 1)?"fail":map));
        
        // trả về collection các keys, values
        System.out.println("keys:"+map.keySet());
        System.out.println("values: "+map.values());
        
        // Khởi tạo LinkedHashMap
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>(Map.of(1,"mot",2,"hai",3,"ba"));
        System.out.println(linkedMap);
        
        // Khởi tạo TreeMap
        TreeMap<Integer, String> treeMap = new TreeMap<>(Map.of(5,"five",1,"one", 4,"four", 2,"two" ));
        System.out.println(treeMap);
    }
    
}
