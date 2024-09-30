import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BrainMonitor brainMonitor = new BrainMonitor();

        // Get input from user for brainwave frequencies and coherence
        System.out.print("Enter alpha wave frequency: ");
        int alphaWave = scanner.nextInt();

        System.out.print("Enter beta wave frequency: ");
        int betaWave = scanner.nextInt();

        System.out.print("Enter coherence level: ");
        int coherence = scanner.nextInt();

        try {
            // Check brain functionality
            brainMonitor.checkBrainFunctionality(alphaWave, betaWave, coherence);
        } catch (BrainFunctionException e) {
            // Handle brain functionality exception
            System.out.println("Exception caught: " + e.getMessage());
            System.out.println("Please consult a healthcare professional.");
        } catch (Exception e) {
            // Handle other exceptions
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

// Custom exception class for brain functionality issues
class BrainFunctionException extends Exception {
    public BrainFunctionException(String message) {
        super(message);
    }
}

// Class representing a healthcare monitor for brain functionality
class BrainMonitor {
    // Method to check brain functionality
    public void checkBrainFunctionality(int alphaWave, int betaWave, int coherence) throws BrainFunctionException {
        // Threshold values for brain functionality
        int minAlphaWave = 10;
        int minBetaWave = 20;
        int minCoherence = 50;

        // Check if any of the values are below the minimum threshold
        if (alphaWave < minAlphaWave || betaWave < minBetaWave || coherence < minCoherence) {
            throw new BrainFunctionException("Brain functionality is below acceptable level!");
        } else {
            System.out.println("Brain functionality is normal.");
        }
    }
}
