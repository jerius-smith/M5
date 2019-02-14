package edu.gatech.cs2340.spacetraders.model;

public enum Difficulty {
    BEGINNER("Beginner"), EASY("Easy"), NORMAL("Normal"), HARD("Hard"), IMPOSSIBLE("Impossible");

    String difficulty;
    private Difficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String toString() {
        return this.difficulty;
    }

}
