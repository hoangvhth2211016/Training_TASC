package Thread.Thread;

import java.util.List;

public class CustomRunnable implements Runnable{
    
    private List<Integer> list;
    
    private int number;
    
    public CustomRunnable(List<Integer> list, int number) {
        this.list = list;
        this.number = number;
    }
    
    @Override
    public void run() {
        // sử dụng synchronized cho toàn bộ phương thức
        add();
    }
    
    private synchronized void add() {
        for (int i = 0; i< 10; i++){
            list.add(number);
        }
    }
}
