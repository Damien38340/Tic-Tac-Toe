package org.example;

import org.example.player.Player;

public class TicTacToe {

    private final int size;
    private final Cell[][] cells;
    private final Menu menu;

    public TicTacToe() {
        size = 3;
        menu = new Menu();
        cells = new Cell[size][size];
    }

    public void populateTable() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public void display() {

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

    public void setOwner(int[] coordinates, Player player) {
        int row = coordinates[0];
        int col = coordinates[1];
        cells[row][col].setRepresentation(player.getRepresentation());
    }

    public boolean checkGameOver(Player currentPlayer) {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                String current = cells[i][j].getRepresentation();

                // Skip empty cells
                if (current.equals("   ")) {
                    continue;
                }

                // Check vertical win
                if (i >= 1 && i < size - 1 &&
                        current.equals(cells[i - 1][j].getRepresentation()) &&
                        current.equals(cells[i + 1][j].getRepresentation())) {
                    display(); // Show the final board
                    menu.victoryMessage(currentPlayer);
                    return true;
                }

                // Check horizontal win
                if (j >= 1 && j < size - 1 &&
                        current.equals(cells[i][j - 1].getRepresentation()) &&
                        current.equals(cells[i][j + 1].getRepresentation())) {
                    display(); // Show the final board
                    menu.victoryMessage(currentPlayer);
                    return true;
                }

                // Check main diagonal win
                if (i >= 1 && i < size - 1 && j >= 1 && j < size - 1 &&
                        current.equals(cells[i - 1][j - 1].getRepresentation()) &&
                        current.equals(cells[i + 1][j + 1].getRepresentation())) {
                    display(); // Show the final board
                    menu.victoryMessage(currentPlayer);
                    return true;
                }

                // Check anti-diagonal win
                if (i >= 1 && i < size - 1 && j >= 1 && j < size - 1 &&
                        current.equals(cells[i - 1][j + 1].getRepresentation()) &&
                        current.equals(cells[i + 1][j - 1].getRepresentation())) {
                    display(); // Show the final board
                    menu.victoryMessage(currentPlayer);
                    return true;
                }
            }
        }

        // Check if the board is full (no empty cells)
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j].getRepresentation().equals("   ")) {
                    return false; // if one of the cells is empty, the game is not over yet
                }
            }
        }

        // Game over with no winner
        display(); // Show the final board
        menu.drawMessage();
        menu.gameOverMessage();
        return true;
    }

    public int getSize() {
        return size;
    }

    public Cell getCell(int row, int col) {
        return cells[row][col]; // Return the Cell object at the specified coordinates
    }

}
