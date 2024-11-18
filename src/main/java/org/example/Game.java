package org.example;

public class Game {
    Player currentPlayer;
    TicTacToe ticTacToe = new TicTacToe();
    AsciiArt asciiArt;


    public void startGame() {
        currentPlayer = new Player("X");
        asciiArt = new AsciiArt();
        while (true) {
            try {
                ticTacToe.display();
                int[] coordinates = ticTacToe.getMoveFromPlayer();
                ticTacToe.setOwner(coordinates, currentPlayer);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
