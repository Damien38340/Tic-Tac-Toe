package org.example;

public class TicTacToe {

    private static final int size = 3;
    private Cell[][] cells;

    public TicTacToe() {
        cells = new Cell[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public void display() {
        System.out.println("--------------");

        for (Cell[] row : cells) {
            System.out.print("|");
            for (Cell cell : row) {
                System.out.print(cell.getRepresentation() + "|");
            }
            System.out.println();
            System.out.println("--------------");
        }
    }
}
