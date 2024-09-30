import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EyeProblemApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Patient> patients = new ArrayList<>();
        Map<String, Patient> patientMap = new HashMap<>(); // Map to store patient details

        System.out.println("Welcome to the Eye Problem Management System");

        // Input data from the user
        while (true) {
            System.out.println("Enter patient's name (type 'done' to finish):");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }

            System.out.println("Enter patient's age:");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter patient's vision power in diopters:");
            double visionPower = Double.parseDouble(scanner.nextLine());

            Patient patient = new Patient(name, age, visionPower);
            patients.add(patient);
            patientMap.put(name, patient); // Store patient details in the map
        }

        // Output patient details
        System.out.println("\nPatient Details:");
        for (Patient patient : patients) {
            System.out.println(patient);
            System.out.println("Treatment: " + patient.provideTreatment());
            System.out.println("Follow-up Care: " + patient.followUpCare());
            System.out.println();
        }
    }
}

// Interface for Eye Problem
interface EyeProblem {
    double calculateTreatmentCost();
}

// Interface for Diagnosis
interface Diagnosis {
    String diagnose();
}

// Interface for Treatment
interface Treatment {
    String provideTreatment();
}

// Interface for Follow-Up Care
interface FollowUpCare {
    String followUpCare();
}

// Class representing a patient with an eye problem
class Patient implements EyeProblem, Diagnosis, Treatment, FollowUpCare {
    private String name;
    private int age;
    private double visionPower; // In diopters
    private String diagnosis;

    public Patient(String name, int age, double visionPower) {
        this.name = name;
        this.age = age;
        this.visionPower = visionPower;
        this.diagnosis = diagnose();
    }

    public double getVisionPower() {
        return visionPower;
    }

    // Implementing methods from interfaces
    public double calculateTreatmentCost() {
        // Example calculation: $1000 per diopter for treatment
        return visionPower * 1000;
    }

    public String diagnose() {
        if (visionPower < 0) {
            return "hyperopia"; // farsightedness
        } else if (visionPower > 0) {
            return "myopia"; // nearsightedness
        } else {
            return "normal vision";
        }
    }

    public String provideTreatment() {
    switch (diagnosis) {
        case "hyperopia":
            return "Prescription glasses with convex lenses are recommended for hyperopia.";
        case "myopia":
            return "Prescription glasses with concave lenses are recommended for myopia.";
        case "normal vision":
            return "No treatment required. Regular eye checkups recommended.";
        default:
            return "Treatment recommendation not available.";
    }
}

    public String followUpCare() {
        // Calculate next appointment date (one month from now)
        LocalDate currentDate = LocalDate.now();
        LocalDate nextAppointmentDate = currentDate.plusMonths(1);
        
        // Format next appointment date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        String formattedNextAppointmentDate = nextAppointmentDate.format(formatter);

        return "Follow-up appointment scheduled for " + formattedNextAppointmentDate;
    }

    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Vision Power: " + visionPower + " diopters, Diagnosis: " + diagnosis;
    }
}
