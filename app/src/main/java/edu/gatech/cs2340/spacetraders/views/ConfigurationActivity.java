package edu.gatech.cs2340.spacetraders.views;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import edu.gatech.cs2340.spacetraders.R;
import edu.gatech.cs2340.spacetraders.model.Difficulty;
import edu.gatech.cs2340.spacetraders.model.Player;
import edu.gatech.cs2340.spacetraders.model.Skills;

public class ConfigurationActivity extends AppCompatActivity {

    private TextView points;
    private EditText nameInput;
    private Spinner difficultySpinner;

    private EditText[] skills = new EditText[4];

    private Player player;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        points = findViewById(R.id.skill_points);
        nameInput = findViewById(R.id.name_input);
        difficultySpinner = findViewById(R.id.difficulty_spinner);

        skills[0] = findViewById(R.id.pilot_skills);
        skills[1] = findViewById(R.id.fighter_skills);
        skills[2] = findViewById(R.id.trader_skills);
        skills[3] = findViewById(R.id.engineer_skills);


        ArrayAdapter<Difficulty> adapter = new ArrayAdapter<Difficulty>(this,
                                                           android.R.layout.simple_spinner_item,
                                                           Difficulty.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(adapter);
        difficultySpinner.setSelection(0);

        player = new Player();

        Log.d("PLAYER_INFO", "" + player.getAvailablePoints());
        points.setText(String.format("%d", player.getAvailablePoints()));
        points.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.setAvailablePoints(player.getAvailablePoints() - 1);
            }
        });
    }

    /**
     * Button handler for the start button
     *
     * @param view the button that was pressed
     *
     */
    public void onAddPressed(View view) {
        Log.d("Edit", "Start New Game Pressed");

        Skills[] skillsArr = {Skills.PILOT, Skills.FIGHTER, Skills.TRADER, Skills.ENGINEER};

        for (int i = 0; i < skillsArr.length; i++) {
            skillsArr[i].setPoints(Integer.parseInt(skills[i].getText().toString()));
        }


        player.setName(nameInput.getText().toString());
        player.setPreferredDifficulty((Difficulty) difficultySpinner.getSelectedItem());
        player.setSkills(skillsArr);

//        Intent intent = new Intent(ConfigurationActivity.this, WelcomeActivity.class);
//        startActivity(intent);

    }

}
