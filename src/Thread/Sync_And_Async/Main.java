package Thread.Sync_And_Async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.lang.Thread.sleep;

public class Main {
    
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        
        // Sử dụng CompletableFuture
        CompletableFuture<Void> thread1 = CompletableFuture.runAsync(()->{
            for(int i = 0; i <10; i++){
                System.out.println(1);
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        
        CompletableFuture<Integer> thread2 = CompletableFuture.supplyAsync(()->{
            for(int i = 0; i <10; i++){
                System.out.println(2);
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return (int) (Math.random()*11);
        });
        
        // kết hợp 2 thread
        thread1.thenCombine(thread2, (rs1,rs2) ->{
                    System.out.println("thread 1 and thread 2 have been combined");
                    if(rs2 < 5) throw new RuntimeException("number too small");
                    return rs2;
        })
                //catch exception có thể xảy ra trong thread
                .exceptionally(ex ->{
                    System.out.println("exception caught: "+ex.getMessage());
                    return 0;
                })
                .thenAccept((res) ->{
                    System.out.println("A random number: "+res);
                })
                .join();
        
    }
    
}
