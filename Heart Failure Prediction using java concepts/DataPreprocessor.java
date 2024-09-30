package com.prediction.util;

import java.util.List;
import java.util.stream.Collectors;

public class DataPreprocessor {

    public static List<double[]> preprocessData(List<HeartFailureRecord> records) {
        // Feature scaling (normalization) for numerical features
        List<double[]> preprocessedData = records.stream()
                .map(record -> new double[]{
                        (record.getAge() - 20) / (100 - 20), // Normalize age
                        record.getAnaemia(),
                        record.getDiabetes(),
                        record.getHighBloodPressure(),
                        (record.getPlatelets() - 25000) / (850000 - 25000), // Normalize platelets
                        (record.getSerumCreatinine() - 0.5) / (9.4 - 0.5), // Normalize serum creatinine
                        (record.getSerumSodium() - 113) / (148 - 113), // Normalize serum sodium
                        record.getSex(),
                        record.getSmoking(),
                        (record.getTime() - 4) / (285 - 4) // Normalize time
                }).collect(Collectors.toList());

        return preprocessedData;
    }
}
