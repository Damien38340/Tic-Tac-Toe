package org.example.controller;

import org.example.model.*;
import org.example.model.player.*;
import org.example.router.UserInteraction;
import org.example.views.View;
import org.example.model.cell.*;

public class Game {
    Player currentPlayer;
    Player firstPlayer;
    Player secondPlayer;
    TicTacToe ticTacToe;
    UserInteraction userInteraction;
    View view;

    public Game() {

        // Initialize game components
        view = new View();
        ticTacToe = new TicTacToe();
        userInteraction = new UserInteraction();
    }

    public void mainMenu() {
        while (true) {
            String gameMode = userInteraction.gameModeChoice(); // Ask the user to select a game mode
            switch (gameMode) {
                case "1":
                    firstPlayer = new HumanPlayer(State.X, "Player 1");
                    secondPlayer = new HumanPlayer(State.O, "Player 2");
                    return;

                case "2":
                    firstPlayer = new HumanPlayer(State.X, "Player 1");
                    secondPlayer = new ArtificialPlayer(State.O, "Awesome-O");
                    return;

                case "3":
                    firstPlayer = new ArtificialPlayer(State.X, "Awesome-O");
                    secondPlayer = new ArtificialPlayer(State.O, "C-16");
                    return;

                default:
                    view.defaultMessage();
            }
        }
    }

    public void startGame() {
        view.displayHomePage();
        ticTacToe.populateTable(); // Prepare the board
        mainMenu();
        // Configure players based on game mode

        currentPlayer = firstPlayer; // Set the starting player

        while (true) {
            try {
                view.displayBoard(ticTacToe.getCells()); // Display the board updated after each turn
                view.playerMessage(currentPlayer); // Display current player's turn

                int[] coordinates;

                do {
                    if (currentPlayer instanceof ArtificialPlayer ap) {
                        coordinates = ap.provideCoordinatesFromComputer(); // Get computer input
                    } else {
                        coordinates = userInteraction.provideCoordinates(); // Get player input
                    }

                } while (!isValidInput(coordinates)); // if the input is not valid, ask the user again to type

                ticTacToe.setOwner(coordinates, currentPlayer);

                // Check if the game is over
                if (isOver() || isDraw()) {
                    break;
                }

                // Switch players
                currentPlayer = (currentPlayer == firstPlayer) ? secondPlayer : firstPlayer;

            } catch (NumberFormatException e) {
                System.err.println("You must enter a number");
            } catch (Exception e) {
                System.err.println("An error occurred during the game: " + e.getMessage());
                e.printStackTrace();
            }

        }
    }

    public boolean isValidInput(int[] coordinates) {
        int row, col;

        row = coordinates[0];
        col = coordinates[1];

        if (row < 0 || row >= ticTacToe.getSize() || col < 0 || col >= ticTacToe.getSize()) {
            view.invalidRowOrColumnMessage();
            return false;
        }
        // Check if the player chose a cell already occupied
        else if (ticTacToe.getCell(row, col).getState() != State.EMPTY) {
            view.cellAlreadyOccupiedMessage();
            return false;
        }
        return true;
    }

    public boolean isOver() {
        int size = ticTacToe.getSize();
        State currentState = currentPlayer.getState();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (checkDirection(i, j, 0, 1, currentState)
                        || checkDirection(i, j, 1, 0, currentState)
                        || checkDirection(i, j, 1, 1, currentState)
                        || checkDirection(i, j, 1, -1, currentState)) return true;
            }
        }
        return false;
    }

    public boolean checkDirection(int i, int j, int u, int v, State currentState) {
        for (int k = 0; k < 3; k++) {
            if (!exist(i + u * k, j + v * k)) {
                return false;
            }
            if (ticTacToe.getCell(i + u * k, j + v * k).getState() != currentState) {
                return false;
            }
        }
        view.displayBoard(ticTacToe.getCells());
        view.victoryMessage(currentPlayer);
        return true;
    }

    public boolean exist(int i, int j) {
        return (i >= 0 && i < ticTacToe.getSize() && j >= 0 && j < ticTacToe.getSize());
    }

    public boolean isDraw() {
        for (int i = 0; i < ticTacToe.getSize(); i++) {
            for (int j = 0; j < ticTacToe.getSize(); j++) {
                if (ticTacToe.getCells()[i][j].getState() == State.EMPTY) {
                    return false; // if one of the cells is empty, the game is not over yet
                }
            }
        }
        //If there's no empty cells left and no winner was declared, this is draw
        // Game over with no winner
        view.displayBoard(ticTacToe.getCells()); // Show the final board
        view.drawMessage();
        view.gameOverMessage();
        return true;
    }
}
