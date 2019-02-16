package edu.gatech.cs2340.spacetraders.views;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.LinkedHashMap;
import java.util.Map;

import edu.gatech.cs2340.spacetraders.R;
import edu.gatech.cs2340.spacetraders.model.Difficulty;
import edu.gatech.cs2340.spacetraders.model.Player;
import edu.gatech.cs2340.spacetraders.model.Skills;

public class ConfigurationActivity extends AppCompatActivity {

    private TextView playerName;
    private TextView difficulty;
    private TextView skillHeader;
    private TextView points;
    private EditText nameInput;
    private EditText pointsInput;
    private Spinner difficultySpinner;
    private Button setupPlayer;
    private RadioGroup skillsGroup;
    private Map<RadioButton, TextView> skillRadio;

    private Player player;
    private int availablePoints;

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
        skillsGroup = (RadioGroup) findViewById(R.id.skill_group);
        skillsGroup.check(R.id.pilot_radio);
        skillRadio = new LinkedHashMap<>(4);
        skillRadio.put((RadioButton) findViewById(R.id.pilot_radio),
                       (TextView) findViewById(R.id.pilot_points));
        skillRadio.put((RadioButton) findViewById(R.id.fighter_radio),
                       (TextView) findViewById(R.id.fighter_points));
        skillRadio.put((RadioButton) findViewById(R.id.trader_radio),
                       (TextView) findViewById(R.id.trader_points));
        skillRadio.put((RadioButton) findViewById(R.id.engineer_radio),
                       (TextView) findViewById(R.id.engineer_points));

        availablePoints = Skills.MAX_POINTS;


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
    }

    private void updatePoints() {
       // points.setText(String.valueOf(availablePoints));
        int input = pointsInput.getInputType();

        skillRadio.forEach((radioButton, textView) -> {

        });

        pointsInput.getText().clear();
    }


}
