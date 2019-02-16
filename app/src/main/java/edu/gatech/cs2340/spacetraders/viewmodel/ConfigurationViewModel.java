package edu.gatech.cs2340.spacetraders.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.widget.Toast;

import edu.gatech.cs2340.spacetraders.model.Difficulty;
import edu.gatech.cs2340.spacetraders.model.ModelFacade;
import edu.gatech.cs2340.spacetraders.model.Player;
import edu.gatech.cs2340.spacetraders.model.Skills;

public class ConfigurationViewModel extends AndroidViewModel {

    private ModelFacade facade;

    public ConfigurationViewModel(@NonNull Application application) {
        super(application);
        facade = ModelFacade.getInstance();
    }

    public void isValidPlayer(String name, Difficulty prefDifficulty, Skills[] skillPoints) {
        if (name == null || name.isEmpty()) {
            Toast.makeText(getApplication(), "Player cannot be configured. Please enter a name",
                           Toast.LENGTH_LONG).show();
        } else if (prefDifficulty == null) {
            Toast.makeText(getApplication(), "Player cannot be configured. Please select "
                                             + "difficulty", Toast.LENGTH_LONG).show();
        } else {
            facade.createPlayer(name, prefDifficulty, skillPoints);
        }
    }
}
