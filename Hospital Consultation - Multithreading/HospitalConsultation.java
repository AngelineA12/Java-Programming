import java.util.Scanner;

public class HospitalConsultation {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Create a doctor
        Doctor doctor = new Doctor("Angeline");

        // Create and start patient threads
        System.out.println("Enter the number of patients:");
        int numPatients = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int i = 0; i < numPatients; i++) {
            System.out.println("Enter name of Patient " + (i + 1) + ":");
            String patientName = scanner.nextLine();
            Thread patientThread = new Thread(new Patient(patientName, doctor));
            patientThread.start();

            // Wait for the patient thread to finish before prompting for the next patient
            try {
                patientThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("All patients have been processed.");
    }

    // Patient class representing patients in the healthcare system
    static class Patient implements Runnable {
        private String name;
        private Doctor doctor;

        public Patient(String name, Doctor doctor) {
            this.name = name;
            this.doctor = doctor;
        }

        @Override
        public void run() {
            // Patient enters the clinic
            System.out.println(name + " enters the clinic.");

            // Patient waits for the doctor
            doctor.visit(this);

            // Patient consults the doctor
            System.out.println(name + " consults the doctor.");
            int consultationFee = 50; // Base consultation fee
            int additionalTestsCost = (int) (Math.random() * 100); // Random additional tests cost
            int totalCost = consultationFee + additionalTestsCost;
            System.out.println(name + " total cost of consultation: $" + totalCost);

            // Patient leaves the clinic
            System.out.println(name + " leaves the clinic.");
        }

        public String getName() {
            return name;
        }
    }

    // Doctor class representing the doctor in the healthcare system
    static class Doctor {
        private String name;

        public Doctor(String name) {
            this.name = name;
        }

        // Method for patients to visit the doctor
        public synchronized void visit(Patient patient) {
            System.out.println("Doctor " + name + " is examining " + patient.getName());
            try {
                Thread.sleep(2000); // Simulating examination time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
