import java.util.Scanner;

public class MedicalProfessionalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input for doctor
        System.out.print("Enter doctor's name:");
        String doctorName = scanner.nextLine();
        System.out.print("Enter doctor's age:");
        int doctorAge = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter doctor's specialization:");
        String doctorSpecialization = scanner.nextLine();

        // Create doctor object
        Doctor doctor = new Doctor(doctorName, doctorAge, doctorSpecialization);

        // Get input for nurse
        System.out.print("Enter nurse's name:");
        String nurseName = scanner.nextLine();
        System.out.print("Enter nurse's age:");
        int nurseAge = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter nurse's department:");
        String nurseDepartment = scanner.nextLine();

        // Create nurse object
        Nurse nurse = new Nurse(nurseName, nurseAge, nurseDepartment);

        // Output
        System.out.println("\nDoctor Details:");
        System.out.println("Name: " + doctor.getName());
        System.out.println("Age: " + doctor.getAge());
        System.out.println("Specialization: " + doctorSpecialization);
        doctor.diagnose(); // Polymorphism

        System.out.println("\nNurse Details:");
        System.out.println("Name: " + nurse.getName());
        System.out.println("Age: " + nurse.getAge());
        System.out.println("Department: " + nurseDepartment);
        nurse.diagnose(); // Polymorphism
    }
}

// Abstract class for healthcare professionals
abstract class HealthcareProfessional {
    protected String name;
    protected int age;

    // Constructor
    public HealthcareProfessional(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Abstract method for diagnosing patients
    abstract void diagnose();

    // Getter method for name
    public String getName() {
        return name;
    }

    // Getter method for age
    public int getAge() {
        return age;
    }
}

// Doctor class inheriting from HealthcareProfessional
class Doctor extends HealthcareProfessional {
    private String specialization;

    // Constructor
    public Doctor(String name, int age, String specialization) {
        super(name, age);
        this.specialization = specialization;
    }

    // Implementation of diagnose method
    @Override
    void diagnose() {
        System.out.println(name + " is diagnosing the patient.");
    }

    // Method to perform surgery - final to prevent overriding
    final void performSurgery() {
        System.out.println(name + " is performing surgery.");
    }
}

// Nurse class inheriting from HealthcareProfessional
class Nurse extends HealthcareProfessional {
    private String department;

    // Constructor
    public Nurse(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    // Implementation of diagnose method
    @Override
    void diagnose() {
        System.out.println(name + " is assisting the doctor in diagnosing the patient.");
    }
}
