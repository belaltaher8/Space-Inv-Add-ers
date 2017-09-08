package com.example.android.galladda.View.QuestionView;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.galladda.R;

import java.util.Random;

/**
 * @author Belal Taher
 * Created on 8/23/2017.
 * The QuestionView class generates the scaffolding for the view of any challenge. Any elements that are common to all the
 * question types will be generated in this class.
 */

public abstract class QuestionView extends LinearLayout{

    //A boolean indicating if the question has been answered yet
    protected boolean correct;

    //A random generator
    protected Random rand;

    //The correct answer choice
    protected int correctChoice;

    //The number of times the user got the question wrong
    protected int numOfWrongTries;

    //The prompt text for the question
    protected TextView questionText;

    //Padding around the question buttons
    public final int PADDING = 20;

    public QuestionView(Context myContext){
        super(myContext);
        rand = new Random();
        setUpQuestion();
        setUpQuestionScreen(myContext);
        setUpAnswerButtons(myContext);
        correct = false;
        this.setBackgroundResource(R.drawable.space);
        numOfWrongTries = 0;
    }

    /**
     * This method is used to set up the question screen itself. It's unimplemented since the prompt for the question
     * depends on the type of challenge being executed.
     */
    protected abstract void setUpQuestion();

    /**
     * This method is used to assign values to the answer buttons. It's unimplemented since the false answers depends on the
     * type of challenge being executed
     * @param myButtons an array containing all the answer buttons
     * @param correctChoice an int indicating which index of the myButtons array will have the right answer choice
     */
    protected abstract void assignValuesToAnswerButtons(Button[] myButtons, int correctChoice);

    /**
     * This method sets up the general layout of the question screen. For all types of challenges, the general layout of the screen
     * is the same
     * @param myContext
     */
    protected void setUpQuestionScreen(Context myContext){
        setOrientation(LinearLayout.VERTICAL);
        questionText = new TextView(myContext);
        questionText.setTextColor(Color.WHITE);
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                0,
                2.0f
        );
        questionText.setLayoutParams((param));
        questionText.setGravity(Gravity.CENTER);
        this.addView(questionText);
    }

    /**
     * This method sets up the answer buttons themselves. Since all types of questions will be multiple choice with four choices,
     * generating four buttons is something you can do without knowing the type of question being executed.
     * @param myContext context for this activity
     */
    protected void setUpAnswerButtons(Context myContext){
        Button choiceOne = new Button(myContext);
        Button choiceTwo = new Button(myContext);
        Button choiceThree = new Button(myContext);
        Button choiceFour = new Button(myContext);
        correctChoice = rand.nextInt(4);
        Button[] myButtons = new Button[4];
        myButtons[0] = choiceOne;
        myButtons[1] = choiceTwo;
        myButtons[2] = choiceThree;
        myButtons[3] = choiceFour;
        formatButtons(myButtons);
        assignValuesToAnswerButtons(myButtons, correctChoice);
        assignOnClickToAnswerButtons(myButtons, correctChoice);
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                0,
                2.0f
        );
        param.setMargins(PADDING, PADDING, PADDING, PADDING);
        setButtonParams(myButtons, param);
        this.addView(choiceOne);
        this.addView(choiceTwo);
        this.addView(choiceThree);
        this.addView(choiceFour);
    }

    /**
     * This method iterates through all the buttons and formats them appropriately
     * @param myButtons an array containing all the answer buttons
     */
    protected void formatButtons(Button[] myButtons){
        for(int i = 0 ; i < myButtons.length; i++){
            Button myButton = myButtons[i];
            myButton.setBackgroundColor(Color.GREEN);
            myButton.setTextColor(Color.BLACK);
            myButton.setPadding(10,10,10,10);
        }
    }

    /**
     * This method assigns on click listeners to all the answer buttons
     * @param myButtons an array containing all the answer buttons
     * @param correctChoice an int indicating which index of the myButtons array holds the correct answer chocie
     */
    protected void assignOnClickToAnswerButtons(Button[] myButtons, int correctChoice){
        myButtons[correctChoice].setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                correct = true;
            }
        });
        for(int i = 0; i < myButtons.length; i++){
            if(i!=correctChoice){
                myButtons[i].setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        questionText.setText("Wrong answer!");
                        numOfWrongTries++;
                    }
                });
            }
        }
    }

    /**
     * This method assigns parameters to all the buttons. All the buttons should be formatted the same for consistency.
     * @param myButtons an array containing all the answer buttons
     * @param param the parameter which should be applied to all the buttons
     */
    protected void setButtonParams(Button[] myButtons, LinearLayout.LayoutParams param){
        for(int i = 0; i < myButtons.length; i ++){
            myButtons[i].setLayoutParams(param);
        }
    }

    /**
     * This method checks if the question has been properly answered yet.
     * @return a boolean flag indicating if the question has been answered yet
     */
    public boolean checkIfQuestionAnswered(){
        return correct;
    }

    public int checkNumOfTimesWrong(){ return numOfWrongTries;}
}

