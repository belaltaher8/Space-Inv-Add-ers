package com.example.android.galladda.GameController;

import android.content.Context;
import android.util.Log;

import com.example.android.galladda.Model.Engines.ChallengeType;
import com.example.android.galladda.Model.GameModel;
import com.example.android.galladda.View.MathView.MathView;
import com.example.android.galladda.View.PlayingView.GameView;

/**
 * Created by Belal Taher on 8/15/2017.
 */

public class GameController implements Runnable{

    private volatile boolean playing;
    private boolean gameViewOn;
    private boolean questionViewOn;

    private GameView myGameView;
    private GameModel myGameModel;
    private MathView myMathView;
    private LevelHandler myLevelHandler;
    private ChallengeHandler myChallengeHandler;

    private Thread gameThread = null;

    long fps;

    private long timeThisFrame;

    Context myContext;

    public GameController(Context context){
        setUpBooleanFlags();
        myContext = context;
        myLevelHandler = new LevelHandler(myContext);
        myGameView = new GameView(myContext, myLevelHandler.getCurrentLevelEM());
        myLevelHandler.takeInScreenDimensions(myGameView.getScreenDimensions());
        myLevelHandler.resetPlayerOne();
        myGameModel = new GameModel(myLevelHandler.getCurrentLevelEM());
        myChallengeHandler = new ChallengeHandler(myLevelHandler.getCurrentLevelEM(), myGameModel.getMyChallengeEngine());
    }

    private void setUpBooleanFlags(){
        playing = true;
        gameViewOn = true;
        questionViewOn = false;
    }

    public GameView getGameView(){
        return myGameView;
    }

    public GameModel getGameModel(){
        return myGameModel;
    }

    public void run(){
        while (playing){
            if(gameViewOn == true){ //PLAY GAME REGULARLY
                playGame();
            }
            if(myChallengeHandler.checkIfChallengeOccured()!=null){ //CHALLENGE HAS TRIGGERED, CHANGE BOOLEAN FLAGS AND RESET ENGINE
                executeChallengeOfType(myChallengeHandler.checkIfChallengeOccured());
                gameViewOn = false;
                questionViewOn = true;
                myChallengeHandler.getMyChallengeEngine().reset();
            }

            if(questionViewOn == true){ //EXECUTE CHALLENGE SCREEN
                playQuestionScreen();
            }
        }
    }

    private void playGame(){
        long startFrameTime = System.currentTimeMillis();
        myGameModel.update();
        myGameView.draw();
        timeThisFrame = System.currentTimeMillis() - startFrameTime;
        if(timeThisFrame > 0){
            fps = 1000/timeThisFrame;
        }
    }

    private void playQuestionScreen(){
        if(myMathView.checkIfQuestionAnswered() == true){
            questionViewOn = false;
            gameViewOn = true;
        }
    }

    private void executeChallengeOfType(ChallengeType CT){
        if(CT.equals(ChallengeType.Math)){
            myMathView = new MathView(myContext);
        }
        if(CT.equals(ChallengeType.Puzzle)){
            //TODO: add Puzzle view
        }
        if(CT.equals(ChallengeType.Shape)){
            //TODO: add Shape view
        }
    }

    public void pause(){
        playing = false;
        try{
            gameThread.join();
        } catch (InterruptedException e){
            Log.e("Error:", "joining thread");
        }
    }

    public void resume(){
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public boolean checkPlaying(){
        return playing;
    }

}

