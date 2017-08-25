package com.example.android.galladda.Activities;

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
        Button myButton = (Button) findViewById(R.id.back_button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //TODO: add another button in horizontal linear layout & another screen to instructions
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
