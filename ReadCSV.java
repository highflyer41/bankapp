import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ReadCSV {
    
    //read data from CSV and puts it into list
    public static List<String[]> read(String file) {
        List<String[]> data = new LinkedList<>();
        String row;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((row = br.readLine()) != null) {
                String[] record = row.split(",");
                data.add(record);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file.");
        } catch (IOException e) {
            System.out.println("Could not read file.");
        } 
        return data;
    }
}