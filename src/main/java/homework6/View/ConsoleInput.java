package homework6.View;

import java.util.Scanner;

public class ConsoleInput implements UserInput {
    private final Scanner scanner = new Scanner(System.in);

    public double readNumber(String numberName) {
        System.out.print("Enter " + numberName + ": ");
        return scanner.nextDouble();
    }

    public String readOperation() {
        System.out.print("Enter operation (+, -, *, /): ");
        return scanner.next();
    }
}
