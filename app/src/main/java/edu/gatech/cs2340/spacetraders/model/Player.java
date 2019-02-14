package edu.gatech.cs2340.spacetraders.model;

public class Player {

    private String name;
    private Skills[] skills;
    private Difficulty preferredDifficulty;
    private int credits;
    private Ship ship;

    public Player(String name) {
        this(name, Difficulty.BEGINNER);
    }

    public Player(String name, Difficulty preferredDifficulty) {
        this.name = name;
        this.preferredDifficulty = preferredDifficulty;
        this.skills = Skills.values();
        this.ship = new Gnat();
        this.credits = 1000;
    }
}
