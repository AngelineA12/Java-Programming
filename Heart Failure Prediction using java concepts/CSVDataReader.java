package com.prediction.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVDataReader<T> {

    public List<T> readCSV(String filePath, CSVMapper<T> mapper) throws IOException {
        List<T> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\JAVA Programs\\Final Project\\heart_failure_clinical_records_dataset.csv"))) {
            String line;
            // Skipping header
            br.readLine();
            while ((line = br.readLine()) != null) {
                T record = mapper.map(line.split(","));
                data.add(record);
            }
        }
        return data;
    }
}
