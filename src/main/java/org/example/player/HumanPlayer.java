package org.example.player;

import org.example.Menu;
import org.example.TicTacToe;

public class HumanPlayer extends Player {

    Menu menu = new Menu();

    public HumanPlayer(String representation, String name) {
        super(representation, name);
    }

    @Override
    public int[] provideCoordinates(TicTacToe game) {
        int row = menu.askingRowNumber() - 1;
        int col = menu.askingColumnNumber() - 1;
        return new int[]{row, col};
    }
}
