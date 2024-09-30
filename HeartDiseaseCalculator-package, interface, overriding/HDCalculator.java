// healthcare/calculation/HeartDiseaseCalculator.java
package healthcare.calculation;

public interface HDCalculator {
    double calculateRiskScore(int age, int gender, int cholesterol, int bloodPressure, int smoker);
}

