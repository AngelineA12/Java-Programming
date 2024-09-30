import java.util.ArrayList;
import java.util.Scanner;

public class BreastCancerData {
    private ArrayList<Patient> patients;

    public BreastCancerData() {
        patients = new ArrayList<>();
    }

    public void addPatient(String name, int age, boolean isCancerous) {
        patients.add(new Patient(name, age, isCancerous));
    }

    public void removePatient(String name) {
        patients.removeIf(patient -> patient.getName().equalsIgnoreCase(name));
    }

    public void displayAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients to display.");
            return;
        }
        System.out.println("All Patients:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    public int getTotalPatients() {
        return patients.size();
    }

    public int getTotalCancerousPatients() {
        int count = 0;
        for (Patient patient : patients) {
            if (patient.isCancerous()) {
                count++;
            }
        }
        return count;
    }

    public double getAverageAge() {
        if (patients.isEmpty()) {
            return 0;
        }
        int totalAge = 0;
        for (Patient patient : patients) {
            totalAge += patient.getAge();
        }
        return (double) totalAge / patients.size();
    }

    public int getMedianAge() {
        if (patients.isEmpty()) {
            return 0;
        }
        ArrayList<Integer> ages = new ArrayList<>();
        for (Patient patient : patients) {
            ages.add(patient.getAge());
        }
        ages.sort(null);
        int size = ages.size();
        if (size % 2 == 0) {
            return (ages.get(size / 2 - 1) + ages.get(size / 2)) / 2;
        } else {
            return ages.get(size / 2);
        }
    }

    public Patient getOldestPatient() {
        if (patients.isEmpty()) {
            return null;
        }
        Patient oldest = patients.get(0);
        for (Patient patient : patients) {
            if (patient.getAge() > oldest.getAge()) {
                oldest = patient;
            }
        }
        return oldest;
    }

    public Patient getYoungestPatient() {
        if (patients.isEmpty()) {
            return null;
        }
        Patient youngest = patients.get(0);
        for (Patient patient : patients) {
            if (patient.getAge() < youngest.getAge()) {
                youngest = patient;
            }
        }
        return youngest;
    }

    public Patient findPatientByName(String name) {
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                return patient;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BreastCancerData data = new BreastCancerData();

        // Collect patient data from the user
        while (true) {
            System.out.println("\nEnter patient details (or type 'done' to finish): ");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Is the patient cancerous? (true/false): ");
            boolean isCancerous = scanner.nextBoolean();
            scanner.nextLine(); // Consume newline

            data.addPatient(name, age, isCancerous);
        }

        // Print statistics
        System.out.println("\nStatistics:");
        System.out.println("Total patients: " + data.getTotalPatients());
        System.out.println("Patients with breast cancer: " + data.getTotalCancerousPatients());
        System.out.println("Average age of patients: " + data.getAverageAge());
        System.out.println("Median age of patients: " + data.getMedianAge());
        System.out.println("Oldest patient: " + data.getOldestPatient().getName());
        System.out.println("Youngest patient: " + data.getYoungestPatient().getName());

        // Search for a patient by name
        System.out.print("\nEnter patient name to search: ");
        String searchName = scanner.nextLine();
        Patient foundPatient = data.findPatientByName(searchName);
        if (foundPatient != null) {
            System.out.println("Patient found - Name: " + foundPatient.getName() + ", Age: " + foundPatient.getAge() + ", Cancerous: " + foundPatient.isCancerous());

            // Perform mammogram test
            MammogramTest mammogramTest = new MammogramTest(foundPatient.isCancerous());
            System.out.println("Mammogram test result: " + (mammogramTest.isPositive() ? "Positive" : "Negative"));

            // Perform chemotherapy test
            ChemotherapyTest chemotherapyTest = new ChemotherapyTest(foundPatient.isCancerous());
            System.out.println("Chemotherapy needed: " + (chemotherapyTest.isNeeded() ? "Yes" : "No"));
        } else {
            System.out.println("Patient not found.");
        }

        // Display all patients
        System.out.println("\n");
        data.displayAllPatients();

        // Ask if the user wants to remove any patients
        System.out.print("\nDo you want to remove any patients? (yes/no): ");
        String removeOption = scanner.nextLine();
        if (removeOption.equalsIgnoreCase("yes")) {
            System.out.print("Enter patient name to remove: ");
            String removeName = scanner.nextLine();
            data.removePatient(removeName);
            System.out.println("Patient " + removeName + " removed.");
        }

        // Display all patients again
        System.out.println("\nUpdated patient list:");
        data.displayAllPatients();
    }
}

class Patient {
    private String name;
    private int age;
    private boolean isCancerous;

    public Patient(String name, int age, boolean isCancerous) {
        this.name = name;
        this.age = age;
        this.isCancerous = isCancerous;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isCancerous() {
        return isCancerous;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Cancerous: " + isCancerous;
    }
}

class MammogramTest {
    private boolean isPositive;

    public MammogramTest(boolean isCancerous) {
        // Mammogram test result is positive for cancerous patients and negative otherwise
        this.isPositive = isCancerous;
    }

    public boolean isPositive() {
        return isPositive;
    }
}

class ChemotherapyTest {
    private boolean isNeeded;

    public ChemotherapyTest(boolean isCancerous) {
        // Chemotherapy is needed for cancerous patients and not needed otherwise
        this.isNeeded = isCancerous;
    }

    public boolean isNeeded() {
        return isNeeded;
    }
}
