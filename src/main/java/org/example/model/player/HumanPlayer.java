package org.example.model.player;

import org.example.model.TicTacToe;
import org.example.model.cell.State;
import org.example.router.UserInteraction;

public class HumanPlayer extends Player {

    UserInteraction userInteraction = new UserInteraction();

    public HumanPlayer(State state, String name) {
        super(state, name);
    }

    @Override
    public int[] provideCoordinates(TicTacToe game) {
        int row = userInteraction.askingRowNumber() - 1;
        int col = userInteraction.askingColumnNumber() - 1;
        return new int[]{row, col};
    }
}
