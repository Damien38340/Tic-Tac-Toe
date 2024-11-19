package org.example;

import org.example.player.Player;

import java.util.Scanner;

public class Menu {

    private final Scanner sc;
    AsciiArt asciiArt = new AsciiArt();


    public Menu() {
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

    public void playerMessage(Player currentPlayer) {
        System.out.println(currentPlayer.getName());
    }

    public void gameOverMessage() {
        asciiArt.gameOverArt();
    }

    public void victoryMessage(Player currentPlayer) {
        System.out.println(currentPlayer.getName() + " won !!");
        asciiArt.victoryArt();
    }

    public void drawMessage() {
        asciiArt.drawArt();
    }

    public void defaultMessage() {
        System.out.println("\n Invalid choice, please select a valid option.");
    }
}
