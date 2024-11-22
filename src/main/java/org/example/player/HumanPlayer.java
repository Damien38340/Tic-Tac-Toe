package org.example.player;

import org.example.UserInteraction;
import org.example.TicTacToe;

public class HumanPlayer extends Player {

    UserInteraction userInteraction = new UserInteraction();

    public HumanPlayer(String representation, String name) {
        super(representation, name);
    }

    @Override
    public int[] provideCoordinates(TicTacToe game) {
        int row = userInteraction.askingRowNumber() - 1;
        int col = userInteraction.askingColumnNumber() - 1;
        return new int[]{row, col};
    }
}
