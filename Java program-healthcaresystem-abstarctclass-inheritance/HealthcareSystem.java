import java.util.Scanner;
// Main class
public class HealthcareSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input patient details
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter patient age: ");
        int age = scanner.nextInt();
        System.out.print("Enter patient gender: ");
        String gender = scanner.next();
        System.out.print("Enter patient weight in kg: ");
        double weight = scanner.nextDouble();
        System.out.print("Enter patient height in meters: ");
        double height = scanner.nextDouble();
        System.out.print("Enter patient current heart rate in bpm: ");
        int heartRate = scanner.nextInt();

        // Creating a Patient object
        Patient patient1 = new EmergencyPatient(name, age, gender);
        // Displaying patient information
        System.out.println("\nPatient Information:");
        patient1.displayInformation();
        
        //Printing the height and weight of the patient
        System.out.println("The height of the patient is: " + height );
        System.out.println("The weight of the patient is: " + weight );


        // Calculating BMI
        double bmi = patient1.calculateBMI(weight, height);
        System.out.println("BMI: " + bmi);
        
        //Printing the current Heart rate of the patient
        System.out.println("The Heart Rate of the patient is: "+heartRate);

        // Predicting heart attack
        boolean willHaveHeartAttack = patient1.predictHeartAttack(bmi, heartRate);
        if (willHaveHeartAttack) {
            System.out.println("Warning: This patient is at risk of a heart attack!");
            System.out.print("Is the patient undergoing treatment? (yes/no): ");
            String undergoingTreatment = scanner.next();
            if (undergoingTreatment.equalsIgnoreCase("yes")) {
                System.out.print("Enter patient's heart rate during treatment in bpm: ");
                int heartRateDuringTreatment = scanner.nextInt();
                boolean willDieDuringTreatment = patient1.predictDeathDuringTreatment(heartRateDuringTreatment);
                if (willDieDuringTreatment) {
                    System.out.println("Warning: This patient might die during treatment!");
                } else {
                    System.out.println("Good news: This patient is not likely to die during treatment.");
                }
            }
        } else {
            System.out.println("Good news: This patient is not at risk of a heart attack.");
        }
    }
}

// Abstract class representing a Patient
abstract class Patient {
    private String name;
    private int age;
    private String gender;

    // Constructor
    public Patient(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Getter methods for encapsulation
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    // Abstract method to display patient information
    public abstract void displayInformation();
    
    // Method to calculate BMI
    public double calculateBMI(double weight, double height) {
        // BMI formula: weight(kg) / (height(m) * height(m))
        return weight / (height * height);
    }
    
    // Method to predict heart attack based on BMI and heart rate
    public boolean predictHeartAttack(double bmi, int heartRate) {
        // Check if heart rate is below 60 or above 100
        if (heartRate < 60 || heartRate > 100) {
            return true;
        }
        // Check if BMI is equal to or greater than 30 (obese)
        if (bmi >= 30) {
            return true;
        }
        return false;
    }
    
    // Method to predict death during treatment based on heart rate
    public boolean predictDeathDuringTreatment(int heartRateDuringTreatment) {
        // Check if heart rate during treatment is greater than 80
        if (heartRateDuringTreatment > 80) {
            return true;
        }
        return false;
    }
}

// Subclass of Patient representing Emergency Patients
class EmergencyPatient extends Patient {

    // Constructor
    public EmergencyPatient(String name, int age, String gender) {
        super(name, age, gender);
    }

    // Method overriding for polymorphism
    @Override
    public void displayInformation() {
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
    }
}
