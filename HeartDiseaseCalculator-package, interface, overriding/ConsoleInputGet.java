// healthcare/input/ConsoleInput.java
package healthcare.input;

import java.util.Scanner;

public class ConsoleInputGet implements UserInputGet {
    private Scanner scanner;

    public ConsoleInputGet() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String getString(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    @Override
    public int getInt(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextInt();
    }
}