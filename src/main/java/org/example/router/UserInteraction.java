package org.example.router;

import org.example.model.TicTacToe;
import org.example.views.View;
import java.util.Scanner;

public class UserInteraction {

    private final Scanner sc;
    View display;

    public UserInteraction() {
        sc = new Scanner(System.in);
        display = new View();
    }

    public String gameModeChoice() {

        display.displayGameModeMenu();

        return sc.nextLine();
    }

    public int askingRowNumber() {

        display.displayRowQuestion();

        return Integer.parseInt(sc.nextLine());
    }

    public int askingColumnNumber() {

        display.displayColQuestion();

        return Integer.parseInt(sc.nextLine());
    }

    public int[] provideCoordinates() {

        int row = askingRowNumber() - 1;
        int col = askingColumnNumber() - 1;
        return new int[]{row, col};
    }

}
