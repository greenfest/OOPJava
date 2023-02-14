package homework5;

import java.util.Scanner;

public class CalculatorView {
    public void printResult(int result) {
        System.out.println("Result: " + result);
    }

    public int getNumber1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        return scanner.nextInt();
    }

    public int getNumber2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter second number: ");
        return scanner.nextInt();
    }

    public String getOperation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter operation (+, -, *, /): ");
        return scanner.nextLine();
    }
}