package org.example.model.player;

import org.example.model.cell.State;
import org.example.model.TicTacToe;

public abstract class Player {
    State state;
    private final String name;

    public Player(State state, String name) {
        this.state = state;
        this.name = name;
    }

    public String getRepresentation() {
        return state.getValue();
    }

    public String getName() {
        return name;
    }

    public abstract int[] provideCoordinates(TicTacToe game);


    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return getRepresentation();
    }
}
