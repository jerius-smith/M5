package edu.gatech.cs2340.spacetraders.model;

public class Player {

    private String name;
    private Skills[] skills;
    private Difficulty preferredDifficulty;
    private int credits;
    private Ship ship;

    public Player() {
        this("", Difficulty.BEGINNER, Skills.values());
    }

    public Player(String name, Difficulty preferredDifficulty, Skills[] skillPoints) {
        this.name = name;
        this.preferredDifficulty = preferredDifficulty;
        this.skills = skillPoints;
        this.ship = new Gnat();
        this.credits = 1000;
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

    @Override
    public String toString() {
        StringBuilder playerInfo = new StringBuilder();
        playerInfo.append("\nPlayer: " + name)
                  .append("\nSelected Difficulty: " + preferredDifficulty)
                  .append("\nPilot points: " + skills[0].getPoints())
                  .append("\nFighter points: " + skills[1].getPoints())
                  .append("\nTrader points: " + skills[2].getPoints())
                  .append("\nEngineer points: " + skills[3].getPoints())
                  .append("\nCredits : " + credits)
                  .append("\nShip type: " + ship);
        return playerInfo.toString();
    }

}
