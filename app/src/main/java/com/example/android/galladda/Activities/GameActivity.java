package com.example.android.galladda.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.galladda.Controller.GameController.GameController;

/**
 * @author Belal Taher
 * Created on 8/24/2017.
 * The GameActivity class is the main game activity. It holds the controller part of the MVC paradigm that this game uses
 */

public class GameActivity extends AppCompatActivity {

    //Game controller functions as the controller of the MVC paradigm
    private GameController gameController;

    /**
     * This method is called on creation of the activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Initializes the controller of the MVC paradigm
        gameController = new GameController(this);

        //Sets the view for this activity as the view of the MVC paradigm
        setContentView(gameController.getGameView());
    }

    @Override
    public void onResume(){
        super.onResume();

        //Resumes the game thread when this activity resumes
        gameController.resume();
    }

    @Override
    public void onPause(){
        super.onPause();

        //Pauses the game thread when this activity pauses
        gameController.pause();
    }
}
