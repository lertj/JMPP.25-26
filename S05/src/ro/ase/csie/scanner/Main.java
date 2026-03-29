package ro.ase.csie.scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter your name here: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("Hello " + name);


    }
}
