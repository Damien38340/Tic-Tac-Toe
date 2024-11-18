package org.example;

import java.util.Scanner;

public class Menu {

    private final Scanner sc;
    AsciiArt asciiArt = new AsciiArt();



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

    public void playerMessage(Player currentPlayer){
        System.out.println(currentPlayer.getName());
    }

    public void gameOverMessage(){
        asciiArt.gameOverArt();
    }

    public void victoryMessage(Player currentPlayer){
        System.out.println(currentPlayer.getName() + " won !!");
    }
}
