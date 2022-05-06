package IO_Operations;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSV_Writer {
    private final CSVWriter writer;

    public CSV_Writer(String filePath) throws IOException {
        // first create file object for file placed at location
        // specified by filepath
        File file = new File(filePath);

        // create FileWriter object with file as parameter
        FileWriter outputfile = new FileWriter(file);

        // create CSVWriter object filewriter object as parameter
        writer = new CSVWriter(outputfile);
    }

    public void writeData(ArrayList<ArrayList<String>> data)
    {
        try {
            for(ArrayList<String> line: data){
                String[] x = new String[line.size()];
                for(int i = 0; i<x.length; i++){
                    x[i] = line.get(i);
                }
                writer.writeNext(x);
            }
//            writer.writeAll(data);
//            // adding header to csv
//            String[] header = { "Name", "Class", "Marks" };
//            writer.writeNext(header);
//
//            // add data to csv
//            String[] data1 = { "Aman", "10", "620" };
//            writer.writeNext(data1);
//            String[] data2 = { "Suraj", "10", "630" };
//            writer.writeNext(data2);

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


}
