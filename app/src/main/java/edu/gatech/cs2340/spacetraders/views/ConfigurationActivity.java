package edu.gatech.cs2340.spacetraders.views;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    private EditText pointsInput;
    private Spinner difficultySpinner;
    private Button setupPlayer;

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
        pointsInput = (EditText) findViewById(R.id.enter_points);
        difficultySpinner = (Spinner) findViewById(R.id.difficulty_spinner);
        setupPlayer = (Button) findViewById(R.id.setup_player);


        ArrayAdapter<Difficulty> adapter = new ArrayAdapter<Difficulty>(this,
                                                           android.R.layout.simple_spinner_item,
                                                           Difficulty.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(adapter);
        difficultySpinner.setSelection(0);

        player = new Player();

        updatePoints();

        pointsInput.setOnEditorActionListener(((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                Log.d("ELEMENTS", "Done editing");
                updatePoints();
            }
            return true;
        }));

//        points.setOnClickListener((view) -> {
//            player.setAvailablePoints(player.getAvailablePoints() - 1);
//            updatePoints();
//            //Log.d("PLAYER_INFO", "" + player.getAvailablePoints());
//        });
    }

    private void updatePoints() {
        //points.setText(String.format("%d", player.getAvailablePoints()));
        points.setText(pointsInput.getText());
        pointsInput.getText().clear();
    }


}
