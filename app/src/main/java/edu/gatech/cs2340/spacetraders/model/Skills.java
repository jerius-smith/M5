package edu.gatech.cs2340.spacetraders.model;

public enum Skills {
    PILOT("Pilot", 0), FIGHTER("Fighter", 0), TRADER("Trader", 0),
    ENGINEER("Engineer", 0);

    private String skill;
    private int points;
    private static int totalPoints;
    public static final int MAX_POINTS = 16;

    private Skills(String skill, int points) {
        this.skill = skill;
        this.points = points;
    }

    public static int totalPoints() {
        int sum = 0;
        for (Skills curr : values())
            sum += curr.points;
        return sum;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String toString() {
        return String.format("Skill %s is assigned %d points", this.skill, this.points);
    }
}
