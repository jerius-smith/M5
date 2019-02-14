package edu.gatech.cs2340.spacetraders.model;

public abstract class Ship {

    private String name;

    public Ship(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " spaceship";
    }
}
