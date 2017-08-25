package com.example.android.galladda.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.android.galladda.R;

/**
 * Created by Belal Taher on 8/24/2017.
 */

public class InstructionActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        Button myEndButton = (Button) findViewById(R.id.back_button);
        myEndButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //TODO: add another button in horizontal linear layout & another screen to instructions
                finish();
            }
        });
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
