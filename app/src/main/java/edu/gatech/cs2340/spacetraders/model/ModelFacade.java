package edu.gatech.cs2340.spacetraders.model;

import android.util.Log;

public class ModelFacade {
    private static final ModelFacade ourInstance = new ModelFacade();

    public static ModelFacade getInstance() {
        return ourInstance;
    }

    private Player player;

    private ModelFacade() {
    }

    public void createPlayer(String name, Difficulty prefDifficulty, Skills[] skillPoints) {
        if (player == null) {
            player = new Player(name, prefDifficulty, skillPoints);
        }
        Log.i("PLAYER", player.toString());
    }
}
