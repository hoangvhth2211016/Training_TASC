package Java_Collection.Array;

import java.util.Arrays;
import java.util.List;

public class Main {
    
    public static void oneDimensionArray(){
        // Khai báo 1 array
        int[] arr1;
        // Khởi tạo giá trị
        arr1 = new int[4];
        // Giá trị khởi tạo các phần tử thuộc int array = 0
        for(int i = 0; i < arr1.length; i++){
            System.out.print(arr1[i]+" ");
            // gán giá trị cho từng phần tử
            arr1[i] = i+1;
        }
        System.out.println();
        for (int e : arr1) {
            System.out.print(e+" ");
        }
        System.out.println();
        // Khai báo và khởi tạo array khi đã biết trc kích thước phần tử
        char[] arr2 = new char[]{'a','s','d','f'};
        double[] arr3 = {1.2,3.4,6.5,1.2};
        for(char c: arr2){
            System.out.print(c+" ");
        }
        System.out.println();
        for(double d: arr3){
            System.out.print(d+" ");
        }
        System.out.println();
    }
    
    public static void multiDimensionArray(){
        // Khai báo 1 array 2 chiều
        int[][] arr;
        // Khởi tạo array với số cột chưa xác định
        arr = new int[3][];
        // Khởi tạo từng hàng với số lượng phần tử khác nhau
        arr[0] = new int[]{1,2,3};
        arr[1] = new int[2];
        arr[1][0] = 21;
        arr[1][1] = 22;
        arr[2] = new int[]{31, 32, 33, 34};
        for(int[] rows: arr){
            for(int e: rows){
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }
    
    public static void copyArray(){
        int[] arr1 = {1,2,3};
        int[] arr2 = arr1;
        
        // sự thay đổi trong arr2 cũng là thay đổi trong arr1
        arr2[0] = 0;
        System.out.println("arr1: ");
        printIntArr(arr1);
        System.out.println("arr2: ");
        printIntArr(arr2);
        
        // sử dung clone
        int[] arr3 = arr1.clone();
        System.out.println("arr3: ");
        printIntArr(arr3);
        
        // thay đổi 1 giá trị trong arr3
        arr3[2] = 4;
        System.out.println("Modified arr3: ");
        printIntArr(arr3);
        System.out.println("arr1: ");
        printIntArr(arr1);
        
        // Sử dụng arraycopy, giá trị đầu vào của phương thức bao gồm:
        // 1. Array nguồn
        // 2. Vị trí bắt đầu copy từ mảng nguồn
        // 3. Array đích
        // 4. Vị trí bắt đầu trong mảng đích, nơi các phần tử bắt đầu sao chép
        // 5. Số lượng phần tử dc sao chép
        int[] arr4 = new int[arr1.length];
        System.arraycopy(arr1,0,arr4,0,arr1.length);
        
    }
    
    public static void performOnClassArrays(){
        int[] arr = {4,2,8};
        
        // toString: hiển thị tất cả các phần tử của mảng
        System.out.println(Arrays.toString(arr));
        
        // deepToString: có thể hiển thị mảng đa chiều
        int [][] multiDArr =new int[][]{{1,2,3},{4,5,6}};
        System.out.println(Arrays.deepToString(multiDArr));
        
        // sort: sắp xếp array theo thứ tự tăng dần
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        
        // binarySearch: dùng để tìm kiếm vị trí của phần tử trong mảng bằng phương pháp binarySearch,
        // giá trị trả về là index của phần từ, nếu ko tìm thấy sẽ trả về <0
        System.out.println("Search 2: "+Arrays.binarySearch(arr, 2));
        System.out.println("Search 3: "+Arrays.binarySearch(arr, 3));
        
        // fill: gán giá trị cho mọi phần tử của arr với giá trị fill
        int[] arr2 = new int[3];
        Arrays.fill(arr2,11);
        System.out.println("arr2: "+Arrays.toString(arr2));
        
        // copyOf: sao chép mảng dc chỉ định vào mảng mới của cùng 1 kiểu. Mảng mới có thể dc cắt ngắn hoặc
        // chèn giá trị mặc định để có độ dài chỉ định
        int[] copyArr = Arrays.copyOf(arr, 5);
        System.out.println("Copied arr: " + Arrays.toString(copyArr));
        
        // copyOfRange: sao chép theo range
        int[] copyRangeArr = Arrays.copyOfRange(arr, 2, 4);
        System.out.println("Copy of range arr: "+ Arrays.toString(copyRangeArr));
        
        // equals: so sánh 2 array
        int[] arr3 = new int[]{2,4,8};
        System.out.println("arr vs arr3: "+Arrays.equals(arr, arr3));
        
        // deepEquals: so sánh sâu 2 tới từng phần từ kể cả trong mảng đa chiều
        int [][] multiDArr2 =new int[][]{{1,2,3},{4,5,8}};
        System.out.println("multiDArr vs multiDArr2: " + Arrays.deepEquals(multiDArr, multiDArr2));
        
        // asList: tạo 1 list từ arr (ArrayList)
        List<int[]> listFromArr = Arrays.asList(arr);
    }
    
    public static void printIntArr(int[] arr){
        for(int e: arr){
            System.out.print(e + (e == arr[arr.length -1]? "\n": " " ));
        }
    }
    
    public static void main(String[] args){
        //oneDimensionArray();
        //multiDimensionArray();
        //copyArray();
        performOnClassArrays();
    }
    
    
}
