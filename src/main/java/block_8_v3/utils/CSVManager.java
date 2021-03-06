package block_8_v3.utils;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVManager {
    public List<String[]> read(String url){
        List<String[]> dataList = null;
        try (CSVReader csvR= new CSVReader(new FileReader(url));){
             dataList = csvR.readAll();
        } catch (IOException e){
            e.printStackTrace();
        }
        return dataList;
    }
}
