package com.example.android.galladda.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.galladda.Controller.GameController.GameController;

/**
 * Created by Belal Taher on 8/24/2017.
 */

public class GameActivity extends AppCompatActivity {

//    private ActivityHandler myActivityHandler;

    private GameController gameController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameController = new GameController(this);
        setContentView(gameController.getGameView());
    }

    @Override
    public void onResume(){
        super.onResume();
        gameController.resume();
    }

    @Override
    public void onPause(){
        super.onPause();
        gameController.pause();
    }
}
