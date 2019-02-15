package edu.gatech.cs2340.spacetraders.views;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import edu.gatech.cs2340.spacetraders.R;
import edu.gatech.cs2340.spacetraders.model.Difficulty;
import edu.gatech.cs2340.spacetraders.model.Player;

public class ConfigurationActivity extends AppCompatActivity {

    private TextView playerName;
    private TextView difficulty;
    private TextView skillHeader;
    private TextView points;
    private EditText nameInput;
    private Spinner difficultySpinner;

    private Player player;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        playerName = (TextView) findViewById(R.id.name_header);
        difficulty = (TextView) findViewById(R.id.difficulty_header);
        skillHeader = (TextView) findViewById(R.id.skill_header);
        points = (TextView) findViewById(R.id.points_header);
        nameInput = (EditText) findViewById(R.id.name_input);
        difficultySpinner = (Spinner) findViewById(R.id.difficulty_spinner);


        ArrayAdapter<Difficulty> adapter = new ArrayAdapter<Difficulty>(this,
                                                           android.R.layout.simple_spinner_item,
                                                           Difficulty.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(adapter);
        difficultySpinner.setSelection(0);

        player = new Player();

        Log.d("PLAYER_INFO", "" + player.getAvailablePoints());
        points.setText(String.format("%d", player.getAvailablePoints()));
        points.setOnClickListener((view) -> {
            player.setAvailablePoints(player.getAvailablePoints() - 1);
        });
    }
}
