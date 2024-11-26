package org.example.model;

import org.example.model.cell.Cell;
import org.example.model.player.Player;

public class TicTacToe {

    private final int size;
    private final Cell[][] cells;

    public TicTacToe() {
        size = 3;
        cells = new Cell[size][size];
    }

    public void populateTable() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public void setOwner(int[] coordinates, Player player) {
        int row = coordinates[0];
        int col = coordinates[1];
        cells[row][col].setState(player.getState());
    }



    public int getSize() {
        return size;
    }

    /**
     * Retrieves the specific Cell object located at the given row and column indices.
     *
     * @param row the row index of the desired cell (0-based).
     * @param col the column index of the desired cell (0-based).
     * @return the Cell object at the specified row and column.
     * @throws ArrayIndexOutOfBoundsException if the row or column indices are out of bounds.
     */
    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    /**
     * Returns the entire 2D array of Cell objects representing the game board.
     *
     * @return a 2D array of Cell objects representing the current state of the board.
     */
    public Cell[][] getCells() {
        return cells;
    }

}
