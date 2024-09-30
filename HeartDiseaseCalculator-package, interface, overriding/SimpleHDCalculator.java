// healthcare/calculation/SimpleHeartDiseaseCalculator.java
package healthcare.calculation;

public class SimpleHDCalculator implements HDCalculator {
    @Override
    public double calculateRiskScore(int age, int gender, int cholesterol, int bloodPressure, int smoker) {
        double riskScore = 0.0;

        if (age >= 45) {
            riskScore += 10.0;
        }

        if (gender == 1) {
            riskScore += 5.0;
        }

        if (cholesterol >= 240) {
            riskScore += 10.0;
        }

        if (bloodPressure >= 140) {
            riskScore += 10.0;
        }

        if (smoker == 1) {
            riskScore += 10.0;
        }

        return riskScore;
    }
}
