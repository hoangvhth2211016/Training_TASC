package Java_Core_Basic.Handle_Exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    
    public static void readFirstLine(String filePath) throws IOException {
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))){
            reader.lines().forEach(System.out::println);
        }catch(Exception e){
            throw new CustomException("unable to read file");
        }
    }
    
    
    public static void main(String [] args){
        try{
        readFirstLine("./src/Java_Core_Basic/DataType/QA.tx");
        }catch(CustomException | IOException e){
            System.out.println(e.getMessage());
        }
    }
    
}
