// healthcare/app/Main.java
package healthcare.app;

import healthcare.input.UserInputGet;
import healthcare.input.ConsoleInputGet;
import healthcare.calculation.HDCalculator;
import healthcare.calculation.SimpleHDCalculator;

public class Main {
    public static void main(String[] args) {
        UserInputGet userInput = new ConsoleInputGet();

        String name = userInput.getString("Patient's Name");
        int age = userInput.getInt("Age (years)");
        int gender = userInput.getInt("Gender (1 for male, 2 for female)");
        int cholesterol = userInput.getInt("Cholesterol Level (mg/dL)");
        int bloodPressure = userInput.getInt("Blood Pressure (mmHg)");
        int smoker = userInput.getInt("Smoker? (1 for yes, 0 for no)");

        HDCalculator calculator = new SimpleHDCalculator();
        double riskScore = calculator.calculateRiskScore(age, gender, cholesterol, bloodPressure, smoker);
        System.out.println("*********************************");
        System.out.println("Patient's RISK SCORE for HEART DISEASE");
        System.out.println("Patient's Name: " + name);
        System.out.println("Estimated Risk Score for Heart Disease: " + riskScore + "%");
        System.out.println("*********************************");
    }
}