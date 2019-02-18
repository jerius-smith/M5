package edu.gatech.cs2340.spacetraders.model;

import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import edu.gatech.cs2340.spacetraders.viewmodel.ConfigurationViewModel;

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
        } else {
            player.setName(name);
            player.setPreferredDifficulty(prefDifficulty);
            player.setSkills(skillPoints);
        }
        Log.d("PLAYER", "\n" + player.toString());
    }

    public Player getPlayer() {
        return player;
    }
}
