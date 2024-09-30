package com.prediction.model;

import java.util.List;

public class HeartFailurePredictionModel {

    private double[] coefficients;

    public void trainModel(List<double[]> data, double[] labels) {
        int numFeatures = data.get(0).length;
        int numSamples = data.size();

        // Initialize coefficients
        coefficients = new double[numFeatures];

        // Gradient Descent optimization
        double learningRate = 0.01;
        int maxIterations = 1000;
        for (int iter = 0; iter < maxIterations; iter++) {
            double[] gradient = new double[numFeatures];
            for (int j = 0; j < numFeatures; j++) {
                for (int i = 0; i < numSamples; i++) {
                    double[] features = data.get(i);
                    double prediction = predict(features);
                    double error = prediction - labels[i];
                    gradient[j] += error * features[j];
                }
                gradient[j] /= numSamples;
            }
            // Update coefficients using gradient descent
            for (int j = 0; j < numFeatures; j++) {
                coefficients[j] -= learningRate * gradient[j];
            }
        }
    }

    public double predict(double[] features) {
        double prediction = 0.0;
        for (int i = 0; i < features.length; i++) {
            prediction += coefficients[i] * features[i];
        }
        // Apply sigmoid function to get probability
        return sigmoid(prediction);
    }

    private double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }
}
