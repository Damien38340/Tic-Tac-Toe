package org.example.model.player;

import org.example.model.TicTacToe;
import org.example.model.cell.State;

import java.util.Random;

public class ArtificialPlayer extends Player {

    private static final Random random = new Random();

    public ArtificialPlayer(State state, String name) {
        super(state, name);
    }

    public int randomRow() {
        return random.nextInt(3);
    }

    public int randomCol() {
        return random.nextInt(3);
    }

    @Override
    public int[] provideCoordinates(TicTacToe game) {

        int row, col;

            row = randomRow();
            col = randomCol();

        return new int[]{row, col};
    }
}
