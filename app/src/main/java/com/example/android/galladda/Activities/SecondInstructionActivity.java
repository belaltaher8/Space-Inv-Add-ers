package com.example.android.galladda.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.android.galladda.R;

/**
 * @author Belal Taher
 * Created on 8/25/2017.
 * The SecondInstructionActivity class is the second screen the user sees in the instructions. It shows the user the controls for the game.
 */

public class SecondInstructionActivity extends AppCompatActivity {


    /**
     * This method is called on creation of the activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Sets the view to the activity_second_instructions.xml file in the res/layout folder
        setContentView(R.layout.activity_second_instructions);

        //Makes it so that wherever the user clicks, he/she is  sent back to the main menu
        LinearLayout myScreen = (LinearLayout) findViewById(R.id.secondscreen);
        myScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }
}
