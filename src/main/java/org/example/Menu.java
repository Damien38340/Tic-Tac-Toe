package org.example;

import java.util.Scanner;

public class Menu {

    private final Scanner sc;


    public Menu() {
        sc = new Scanner(System.in);
    }

    public int askingRowNumber() {
        System.out.println("Enter row number (1, 2 or 3): ");
        return sc.nextInt();
    }

    public int askingColumnNumber() {
        System.out.println("Enter column number (1, 2 or 3): ");
        return sc.nextInt();
    }
}
