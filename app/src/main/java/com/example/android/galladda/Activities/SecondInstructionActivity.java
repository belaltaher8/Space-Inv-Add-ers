package com.example.android.galladda.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.android.galladda.R;

/**
 * Created by Belal Taher on 8/25/2017.
 */

public class SecondInstructionActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_instructions);
        LinearLayout myScreen = (LinearLayout) findViewById(R.id.secondscreen);
        myScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
