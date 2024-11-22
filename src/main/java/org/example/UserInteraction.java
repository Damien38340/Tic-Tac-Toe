package org.example;

import java.util.Scanner;

public class UserInteraction {

    private final Scanner sc;

    public UserInteraction() {
        sc = new Scanner(System.in);
    }

    public String mainMenu(){

        System.out.println("1. Player 1 VS Player 2");
        System.out.println("2. Player 1 VS CPU");
        System.out.println("3. CPU VS CPU");

        return sc.nextLine();
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
