package com.prediction.service;

import com.prediction.model.HeartFailurePredictionModel;
import com.prediction.util.CSVDataReader;
import com.prediction.util.DataPreprocessor;
import com.prediction.util.HeartFailureRecord;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HeartFailurePredictionService {

    public static void main(String[] args) {
        try {
            // Load heart failure dataset
            System.out.println("Loading heart failure dataset...");
            CSVDataReader<HeartFailureRecord> csvReader = new CSVDataReader<>();
            List<HeartFailureRecord> records = csvReader.readCSV("D:/JAVA Programs/Final Project/heart_failure_clinical_records_dataset.csv", HeartFailureRecord::new);
            System.out.println("Dataset loaded successfully.");

            // Preprocess data
            System.out.println("Preprocessing data...");
            List<double[]> preprocessedData = DataPreprocessor.preprocessData(records);
            System.out.println("Data preprocessing completed.");

            // Split data into training and testing sets
            int totalSamples = preprocessedData.size();
            int trainingSamples = (int) (totalSamples * 0.8);
            int testingSamples = totalSamples - trainingSamples;
            System.out.println("Total number of samples: " + totalSamples);
            System.out.println("Number of samples for training: " + trainingSamples);
            System.out.println("Number of samples for testing: " + testingSamples);

            List<double[]> trainingData = preprocessedData.subList(0, trainingSamples);
            List<double[]> testingData = preprocessedData.subList(trainingSamples, totalSamples);

            double[] labels = records.stream().mapToDouble(HeartFailureRecord::getDEATH_EVENT).toArray();
            double[] trainingLabels = new double[trainingSamples];
            double[] testingLabels = new double[testingSamples];

            System.arraycopy(labels, 0, trainingLabels, 0, trainingSamples);
            System.arraycopy(labels, trainingSamples, testingLabels, 0, testingSamples);

            // Train model
            System.out.println("Training the heart failure prediction model...");
            HeartFailurePredictionModel model = new HeartFailurePredictionModel();
            model.trainModel(trainingData, trainingLabels);
            System.out.println("Training completed.");

            // Perform prediction on testing set
            System.out.println("Performing prediction on the testing set...");
            List<Double> predictions = new ArrayList<>();
            List<Double> residuals = new ArrayList<>();
            for (int i = 0; i < testingData.size(); i++) {
                double[] features = testingData.get(i);
                double prediction = model.predict(features);
                double actual = testingLabels[i];
                double residual = Math.abs(prediction - actual); // Calculate residual
                predictions.add(prediction);
                residuals.add(residual);
                System.out.println("Sample " + (i + 1) + ": Predicted = " + prediction + ", Actual = " + actual + ", Residual = " + residual);
            }
            System.out.println("Prediction completed.");

            // Calculate accuracy
            double accuracy = calculateAccuracy(predictions, testingLabels);
            System.out.println("Accuracy of the model: " + accuracy);

            // Calculate mean residual
            double meanResidual = calculateMean(residuals);
            System.out.println("Mean residual: " + meanResidual);

            // Conclusion
            System.out.println("\nConclusion:");
            System.out.println("The heart failure prediction model has been trained and tested successfully.");
            System.out.println("The accuracy of the model on the testing set is " + accuracy + ".");
            System.out.println("The mean residual, which measures the average deviation of predictions from actual values, is " + meanResidual + ".");
            System.out.println("Further evaluation and validation may be necessary to assess the model's performance in clinical settings.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double calculateAccuracy(List<Double> predictions, double[] actualLabels) {
        int correctPredictions = 0;
        for (int i = 0; i < predictions.size(); i++) {
            double prediction = predictions.get(i);
            if ((prediction >= 0.5 && actualLabels[i] == 1) || (prediction < 0.5 && actualLabels[i] == 0)) {
                correctPredictions++;
            }
        }
        return (double) correctPredictions / predictions.size();
    }

    private static double calculateMean(List<Double> values) {
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.size();
    }
}
