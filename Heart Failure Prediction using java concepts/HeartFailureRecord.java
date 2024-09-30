package com.prediction.util;

public class HeartFailureRecord {

    // Define attributes according to dataset columns
    private double age;
    private double anaemia;
    private double diabetes;
    private double highBloodPressure;
    private double platelets;
    private double serumCreatinine;
    private double serumSodium;
    private double sex;
    private double smoking;
    private double time;
    private double DEATH_EVENT;

    public HeartFailureRecord(String[] data) {
        this.age = Double.parseDouble(data[0]);
        this.anaemia = Double.parseDouble(data[1]);
        this.diabetes = Double.parseDouble(data[2]);
        this.highBloodPressure = Double.parseDouble(data[3]);
        this.platelets = Double.parseDouble(data[4]);
        this.serumCreatinine = Double.parseDouble(data[5]);
        this.serumSodium = Double.parseDouble(data[6]);
        this.sex = Double.parseDouble(data[7]);
        this.smoking = Double.parseDouble(data[8]);
        this.time = Double.parseDouble(data[9]);
        this.DEATH_EVENT = Double.parseDouble(data[10]);
    }

    // Getters
    public double getAge() {
        return age;
    }

    public double getAnaemia() {
        return anaemia;
    }

    public double getDiabetes() {
        return diabetes;
    }

    public double getHighBloodPressure() {
        return highBloodPressure;
    }

    public double getPlatelets() {
        return platelets;
    }

    public double getSerumCreatinine() {
        return serumCreatinine;
    }

    public double getSerumSodium() {
        return serumSodium;
    }

    public double getSex() {
        return sex;
    }

    public double getSmoking() {
        return smoking;
    }

    public double getTime() {
        return time;
    }

    public double getDEATH_EVENT() {
        return DEATH_EVENT;
    }
}
