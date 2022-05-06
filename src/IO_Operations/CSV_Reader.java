package IO_Operations;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSV_Reader {
    private final CSVReader csvReader;

    public CSV_Reader(String filePath) throws IOException {
        // first create file object for file placed at location
        // specified by filepath
        File file = new File(filePath);

        // Create an object of file reader
        // class with CSV file as a parameter.
        FileReader fileReader = new FileReader(file);

        // create csvReader object and skip first Line
        csvReader = new CSVReader(fileReader);
    }

    public ArrayList<ArrayList<String>> readAllDataAtOnce(String fileName)
    {
        try {
            List<String[]> allData = csvReader.readAll();

//            // print Data
//            for (String[] row : allData) {
//                for (String cell : row) {
//                    System.out.print(cell + "\t");
//                }
//                System.out.println();
//            }
            ArrayList<ArrayList<String>> transformedData = new ArrayList<>();
            for(String[] line: allData){
                ArrayList<String> arrayListLine = new ArrayList<>(Arrays.asList(line));
                transformedData.add(arrayListLine);
            }

            return transformedData;
        }

        catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


}
