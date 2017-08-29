package com.example.android.galladda.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.android.galladda.R;

/**
 * @author Belal Taher
 * Created on 8/24/2017.
 * The InstructionActivity class is the first instruction screen that the player sees. It describes the story of the game.
 */

public class InstructionActivity extends AppCompatActivity {


    /**
     * This method is called on creation of the activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Sets the view to the activity_instructions.xml file in the layout resources folder
        setContentView(R.layout.activity_instructions);

        //Makes the "Back" button finish this activity
        Button myEndButton = (Button) findViewById(R.id.back_button);
        myEndButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //TODO: add another button in horizontal linear layout & another screen to instructions
                finish();
            }
        });

        //Makes the "Controls" button go to the second instructions screen
        Button myNextButton = (Button) findViewById(R.id.next_button);
        myNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext() , SecondInstructionActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void onResume(){
        super.onResume();
    }

    public void onPause(){
        super.onPause();
    }

    @Override
    public void onBackPressed(){
        finish();
    }
}
