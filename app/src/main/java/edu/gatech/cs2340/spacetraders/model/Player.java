package edu.gatech.cs2340.spacetraders.model;

public class Player {

    private String name;
    private Skills[] skills;
    private Difficulty preferredDifficulty;
    private int credits;
    private Ship ship;
    private int availablePoints;

    public Player() {
        this("", Difficulty.BEGINNER);
    }

    public Player(String name, Difficulty preferredDifficulty) {
        this.name = name;
        this.preferredDifficulty = preferredDifficulty;
        this.skills = Skills.values();
        this.ship = new Gnat();
        this.credits = 1000;
        this.availablePoints = Skills.MAX_POINTS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Skills[] getSkills() {
        return skills;
    }

    public void setSkills(Skills[] skills) {
        this.skills = skills;
    }

    public Difficulty getPreferredDifficulty() {
        return preferredDifficulty;
    }

    public void setPreferredDifficulty(Difficulty preferredDifficulty) {
        this.preferredDifficulty = preferredDifficulty;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public int getAvailablePoints() {
        return availablePoints;
    }

    public void setAvailablePoints(int availablePoints) {
        this.availablePoints = availablePoints;
    }
}
