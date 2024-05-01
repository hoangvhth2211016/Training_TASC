package Assignment_Java_Core.FileHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvHandler implements FileHandler {
    
    private final String path;
    
    public CsvHandler(String path) {
        this.path = path;
    }
    
    @Override
    public synchronized List<String[]> read() {
        List<String[]> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                list.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    @Override
    public synchronized void write(List<String> list) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for(String str: list){
                writer.write(str);
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
