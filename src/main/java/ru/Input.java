package ru;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    Scanner scanner = new Scanner(System.in);

    protected int inputInt() {
        while(true) {
            try {

                int valueInt = scanner.nextInt();

                scanner.nextLine();  // для отчистки буфера от \n

                return valueInt;

            } catch (InputMismatchException e) {
                exceptionMessage();
            }
        }
    }

    protected String inputString() {

        String valueString = scanner.nextLine();

        return valueString;
    }

    private void exceptionMessage() {
        System.out.println("НЕОБХОДИМО ВВЕСТИ ИМЕННО ЦИФРУ");
        scanner.nextLine();  // для отчистки буфера от \n
    }
}
