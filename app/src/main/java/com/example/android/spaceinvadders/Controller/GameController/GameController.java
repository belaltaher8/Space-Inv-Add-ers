package com.example.android.spaceinvadders.Controller.GameController;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.android.spaceinvadders.Activities.GameOverActivity;
import com.example.android.spaceinvadders.Activities.QuestionActivity;
import com.example.android.spaceinvadders.Activities.WinActivity;
import com.example.android.spaceinvadders.EntityComponent.Entities.Enum.EntityType;
import com.example.android.spaceinvadders.Model.GameModel.GameModel;
import com.example.android.spaceinvadders.View.GameView.GameView;

/**
 * @author Belal Taher
 * Created on 8/15/2017.
 * The GameController class functions as the controller for the MVC paradigm. It handles communication between the view and the model.
 */

public class GameController implements Runnable{

    //Boolean flag that indicates to the main game thread when to pause and when to play
    private volatile boolean playing;

    //The model and the view for the MVC paradigm
    private GameView myGameView;
    private GameModel myGameModel;

    //The main game thread
    private Thread gameThread = null;

    //Instance variables to calculate FPS
    long fps;
    private long timeThisFrame;

    Context myContext;

    /**
     * This constructor creates all the necessary components of the MVC paradigm and handles initial communication between them
     * @param context
     */
    public GameController(Context context){
        myContext = context;

        //Constructs the model and view components of the MVC paradigm
        myGameView = new GameView(myContext);
        myGameModel = new GameModel(myContext);

        //Passes screen dimensions from the view to the model
        myGameModel.takeInScreenDimensions(myGameView.getScreenDimensions());

        //Passes the entity manager from the model to the view
        myGameView.attachEM(myGameModel.getMyLevelHandler().getCurrentLevelEM());

        //Initializes level 1
        myGameModel.getMyLevelHandler().initializeLevel(1);
    }

    /**
     * This method gets the view component of the MVC paradigm
     * @return the view of the MVC paradigm
     */
    public GameView getGameView(){
        return myGameView;
    }

    /**
     * This method gets the model component of the MVC paradigm
     * @return the model of the MVC paradigm
     */
    public GameModel getGameModel(){
        return myGameModel;
    }

    /**
     * This method handles all the necessary updates on each iteration of the main game thread
     */
    public void run(){
        //While the boolean flag to play is true (a.k.a the game is NOT paused)
        while (playing){

            if(myGameModel.getMyLevelHandler().checkIfWon() == true){
                executeWinScreen();
            }

            //play the game
            playGame();

            //and check if a challenge is occuring
            if(myGameModel.getMyChallengeHandler().checkIfChallengeOccured()==true){

                //If a challenge should occur, execute that challenge and
                //reset the challenge engine to avoid triggering infinite challenges
                executeChallengeOfType(myGameModel.getMyChallengeHandler().getMyChallengeType());
                myGameModel.getMyChallengeHandler().getMyChallengeEngine().reset();
            }
            else if(myGameModel.getMyLevelHandler().checkIfPlayerDied() == true){

                //If the player dies, execute a game over activity
                executeGameOverScreen();
                myGameModel.getMyLevelHandler().getMyLivesEngine().reset();
            }
            else if(myGameModel.getMyLevelHandler().goToNextLevel() == true){

                myGameModel.getMyLevelHandler().initializeLevel(myGameModel.getMyLevelHandler().getLevel() + 1);
                myGameModel.getMyLevelHandler().getMyLevelEngine().reset();
            }
        }
    }

    private void executeWinScreen(){

        Intent intent = new Intent();
        intent.setClass(myContext, WinActivity.class);

        Activity myActivity = (Activity) myContext;
        myActivity.finish();
        myContext.startActivity(intent);
        myActivity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    /**
     * This method sets the boolean flag that controls the main game thread to false so it knows to stop updating both
     * the model and view when the game is paused
     */
    public void pause(){
        playing = false;
        try{
            gameThread.join();
        } catch (InterruptedException e){
            Log.e("Error:", "joining thread");
        }
    }

    /**
     * This method sets the boolean flag that controls the main game therad to true so it knows to resume updating both
     * the model and view when the game is resumed
     *
     */
    public void resume(){
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * This method calculates the frames per second handles updating the view and model components of the MVC paradigm
     */
    private void playGame(){

        //Update the game model and draw all the entities to the screen
        myGameView.draw();
        myGameModel.update();


        //FPS calculations
        long startFrameTime = System.currentTimeMillis();
        timeThisFrame = System.currentTimeMillis() - startFrameTime;
        if(timeThisFrame > 0){
            fps = 1000/timeThisFrame;
        }
    }


    /**
     * This method handles executing a challenge of any type
     * @param CT An enum indicating what kind of challenge to execute
     */
    private void executeChallengeOfType(EntityType CT){

        //Creates a intent for QuestionActivity and packs info indicating what kind of question this will be
        Intent intent = new Intent();
        intent.putExtra("Challenge Type", CT.name());
        intent.setClass(myContext, QuestionActivity.class);

        Activity myActivity = (Activity) myContext;
        //Starts the question activity
        myActivity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        myActivity.startActivityForResult(intent, 1);
    }

    private void executeGameOverScreen(){
        Intent intent = new Intent();
        intent.setClass(myContext, GameOverActivity.class);

        Activity myActivity = (Activity) myContext;
        myActivity.startActivityForResult(intent, 2);
    }

    public void passNumOfTimesWrong(int num){
        myGameModel.passNumOfTimesWrong(num);
    }

    public void passReplay(boolean replay){
        myGameModel.passReplay(replay);
    }





}

