package com.example.android.galladda.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.android.galladda.R;

/**
 * Created by Belal Taher on 9/7/2017.
 */

public class GameOverActivity extends AppCompatActivity {

    public static final int RESUME = 1;

    /**
     * This method is called on creation of the activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Sets the view to the activity_instructions.xml file in the res/layout folder
        setContentView(R.layout.activity_gameover);

        Button tryAgainButton = (Button) findViewById(R.id.try_again_button);

        tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESUME);
                Log.d("TAG", "GETS HERE");
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        });
    }
}
