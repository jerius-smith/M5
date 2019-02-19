package edu.gatech.cs2340.spacetraders.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.widget.Toast;

import java.util.Arrays;

import edu.gatech.cs2340.spacetraders.model.Difficulty;
import edu.gatech.cs2340.spacetraders.model.ModelFacade;
import edu.gatech.cs2340.spacetraders.model.Skills;

public class ConfigurationViewModel extends AndroidViewModel {

    private ModelFacade facade;

    public ConfigurationViewModel(@NonNull Application application) {
        super(application);
        facade = ModelFacade.getInstance();
    }

    public void isValidPlayer(String name, Difficulty prefDifficulty, Skills[] skillPoints) {
        if (name == null || name.isEmpty()) {
            showToast("Player cannot be configured. Please enter a name", Toast.LENGTH_LONG);
        } else if (prefDifficulty == null) {
            showToast("Player cannot be configured. Please select difficulty", Toast.LENGTH_LONG);
        } else if (Skills.totalPoints() != Skills.MAX_POINTS) {
            showToast("Player cannot be configured. Please allocate all the points: " + Skills.totalPoints(), Toast.LENGTH_LONG);
        } else {
            facade.createPlayer(name, prefDifficulty, skillPoints);
            showToast(facade.getPlayer().toString(), 5000);
        }
    }

    private void showToast(String message, int duration) {
        Toast.makeText(getApplication(), message, duration).show();
    }
}
