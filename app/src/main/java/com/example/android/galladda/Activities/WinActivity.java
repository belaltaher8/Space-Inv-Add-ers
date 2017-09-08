package com.example.android.galladda.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.android.galladda.R;

/**
 * Created by Belal Taher on 9/8/2017.
 */

public class WinActivity extends AppCompatActivity {

    /**
     * This method is called on creation of the activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Sets the view to the activity_instructions.xml file in the res/layout folder
        setContentView(R.layout.activity_win);

        Button winButton = (Button) findViewById(R.id.go_back_button);

        winButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });


    }
}
