package Assignment_Java_Core.FileHandler;

import java.util.List;

public interface FileHandler {
    
    List<String []> read();
    
    void write(List<String> list);
    
}
