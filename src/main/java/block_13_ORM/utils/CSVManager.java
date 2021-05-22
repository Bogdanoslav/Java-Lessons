package block_13_ORM.utils;

import block_13_ORM.exceptions.ReadCsvException;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVManager {
    public List<String[]> read(String url) throws ReadCsvException {
        List<String[]> dataList = null;
        try (CSVReader csvR= new CSVReader(new FileReader(url))){
             dataList = csvR.readAll();
        } catch (IOException e){
            throw new ReadCsvException("Error while reading CSV " + url, e);
        }
        return dataList;
    }
}
