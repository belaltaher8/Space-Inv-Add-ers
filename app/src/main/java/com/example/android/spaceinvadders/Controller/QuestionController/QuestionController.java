package com.example.android.spaceinvadders.Controller.QuestionController;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.example.android.spaceinvadders.EntityComponent.Entities.Enum.EntityType;
import com.example.android.spaceinvadders.View.QuestionView.MathView;
import com.example.android.spaceinvadders.View.QuestionView.PuzzleView;
import com.example.android.spaceinvadders.View.QuestionView.QuestionView;
import com.example.android.spaceinvadders.View.QuestionView.ShapeView;

/**
 * @author Belal Taher
 * Created on 8/19/2017.
 * The QuestionController class handles making sure the right question is initializes and constantly checks to see if the question
 * has been answered yet
 */

public class QuestionController implements Runnable {

    //Boolean flag for whether or not the question has been answered yet
    private boolean answered = false;

    //Thread for the question activity
    private Thread questionThread = null;

    //Instance variables to calculate FPS
    long fps;
    private long timeThisFrame;

    //Boolean flag that indicates to the question thread when to pause and when to resume
    private boolean playing;

    //View for the challenge being currently executed
    private QuestionView myQuestionView;

    //Context for app
    private Context myContext;

    /**
     * The QuestionController constructor decides which type of question view will be created
     * @param context context for app
     * @param CT Enum indicating what kind of challenge the controller should create a view for
     */
    public QuestionController(Context context, EntityType CT){
        //TODO: MAKE THIS BETTER
        myContext = context;
        if(CT.equals(EntityType.MathEnemy)){
            myQuestionView = new MathView(context);
        }
        else if(CT.equals(EntityType.ShapeEnemy)){
            myQuestionView = new ShapeView(context);
        }
        else if(CT.equals(EntityType.PuzzleEnemy)){
            myQuestionView = new PuzzleView(context);
        }
    }

    /**
     * Gets the question view
     * @return the view for the question currently being executed
     */
    public QuestionView getMyQuestionView(){
        return myQuestionView;
    }

    /**
     * This method handles checking if the question has been answered yet
     */
    public void run(){
        while (playing){

            //Checks if the question has been correctly answered
            checkIfAnswered();

            //If it has been answered correctly
            if(answered == true){
                //Finish this activity
                ((Activity) myContext).setResult(myQuestionView.checkNumOfTimesWrong());
                ((Activity) myContext).overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                ((Activity) myContext).finish();
            }
        }
    }

    /**
     * This method is called by the thread's run method to see if the question has been answered yet and calculates the FPS
     */
    private void checkIfAnswered(){

        //Checks question view to see if button with correct answer choice has been clicked yet
        answered = myQuestionView.checkIfQuestionAnswered();

        //FPS calculations
        long startFrameTime = System.currentTimeMillis();
        timeThisFrame = System.currentTimeMillis() - startFrameTime;
        if(timeThisFrame > 0){
            fps = 1000/timeThisFrame;
        }
    }

    /**
     * This method makes sure the game thread pauses when the app is paused
     */
    public void pause(){
        playing = false;
        try{
            questionThread.join();
        } catch (InterruptedException e){
            Log.e("Error:", "joining thread");
        }
    }

    /**
     * This method makes sure the game thread resumes when the app resumes
     */
    public void resume(){
        playing = true;
        questionThread = new Thread(this);
        questionThread.start();
    }


}
