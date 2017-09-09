package com.example.android.spaceinvadders.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.android.spaceinvadders.R;

/**
 * @author Belal Taher
 * Created on 8/24/2017.
 * The InstructionActivity class is the activity that presents the story of the game.
 */

public class InstructionActivity extends AppCompatActivity {


    /**
     * This method is called on creation of the activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Sets the view to the activity_instructions.xml file in the res/layout folder
        setContentView(R.layout.activity_instructions);

        //Makes the "Back" button finish this activity
        Button myEndButton = (Button) findViewById(R.id.back_button);
        myEndButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
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
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
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
