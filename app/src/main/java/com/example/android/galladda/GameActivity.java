package com.example.android.galladda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.galladda.GameController.PlayingController.GameController;

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

    public void onResume(){
        super.onResume();
        gameController.resume();
    }

    public void onPause(){
        super.onPause();
        gameController.pause();
    }
}
