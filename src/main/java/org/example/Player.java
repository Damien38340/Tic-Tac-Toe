package org.example;

public class Player {
    private final String representation;
    private String name;

    public Player(String representation, String name) {
        this.representation = representation;
        this.name = name;
    }

    public String getRepresentation() {
        return representation;
    }
    public String getName() {
        return this.name = name;
    }
}
