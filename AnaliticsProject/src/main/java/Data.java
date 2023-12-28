import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.FileReader;
import java.util.ArrayList;
public class Data {
    public static ArrayList<String[]> readDataLineByLine(String file) {
        try{
            ArrayList<String[]> lines = new ArrayList<String[]>();
            FileReader filereader = new FileReader(file);
            CSVReader csvReader = new CSVReaderBuilder(filereader).build();
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                lines.add(String.join(" ",nextRecord).split(";"));
            }
            return lines;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
