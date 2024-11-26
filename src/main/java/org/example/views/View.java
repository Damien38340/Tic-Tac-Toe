package org.example.views;

import org.example.model.cell.Cell;
import org.example.model.player.Player;

public class View {

    AsciiArt asciiArt = new AsciiArt();

    public void displayHomePage() {
        asciiArt.homePage(); // Display the homepage
    }

    public void displayGameModeMenu() {

        System.out.println("1. Player 1 VS Player 2");
        System.out.println("2. Player 1 VS CPU");
        System.out.println("3. CPU VS CPU");
    }

    public void displayRowQuestion() {
        System.out.println("Enter row number (1, 2 or 3): ");

    }

    public void displayColQuestion() {
        System.out.println("Enter column number (1, 2 or 3): ");

    }


    public void displayBoard(Cell[][] cells) {

        System.out.println("   1    2    3"); // Column headers
        System.out.println("  --------------");

        for (int i = 0; i < cells.length; i++) { // Use a traditional for loop to track row index
            System.out.print((i + 1) + " |"); // Print row number
            for (Cell cell : cells[i]) {
                System.out.print(cell.getRepresentation() + "|"); // Print cell contents
            }
            System.out.println(); // Move to the next line
            System.out.println("  --------------"); // Row separator
        }
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

    public void invalidRowOrColumnMessage() {
        System.out.println("Invalid row or column number. Please try again.");
    }

    public void cellAlreadyOccupiedMessage() {
        System.out.println("Cell is already occupied. Please choose an empty cell.");

    }

    public void numberFormatExceptionMessage() {
        System.out.println("Invalid input. Please enter valid numbers.");

    }

}
