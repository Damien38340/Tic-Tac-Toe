package org.example;

public class Game {
    Player currentPlayer;
    Player firstPlayer;
    Player secondPlayer;
    TicTacToe ticTacToe;
    AsciiArt asciiArt;
    Menu menu;

    public Game() {
        firstPlayer = new Player(" X ", "Player 1");
        secondPlayer = new Player(" O ", "Player 2");
        ticTacToe = new TicTacToe();
        asciiArt = new AsciiArt();
        menu = new Menu();
    }

    public void startGame() {
        currentPlayer = firstPlayer;
        asciiArt.homePage();
        ticTacToe.populateTable();

        while (true) {
            try {
                ticTacToe.display();
                menu.playerMessage(currentPlayer);
                int[] coordinates = ticTacToe.getMoveFromPlayer();
                ticTacToe.setOwner(coordinates, currentPlayer);

                if (ticTacToe.checkGameOver(currentPlayer)){ //check if all the cells are filled
                    break;
                }

                if (currentPlayer == firstPlayer) {
                    currentPlayer = secondPlayer;
                } else {
                    currentPlayer = firstPlayer;
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
