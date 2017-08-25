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
 * Created by Belal Taher on 8/23/2017.
 */

public abstract class QuestionView extends LinearLayout{

    protected boolean correct;
    protected Random rand;
    protected int correctChoice;

    protected int numOfWrongTries;

    protected TextView questionText;

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

    protected abstract void setUpQuestion();

    protected abstract void assignValuesToAnswerButtons(Button[] myButtons, int correctChoice);

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

    protected void formatButtons(Button[] myButtons){
        for(int i = 0 ; i < myButtons.length; i++){
            Button myButton = myButtons[i];
            myButton.setBackgroundColor(Color.WHITE);
            myButton.setTextColor(Color.BLACK);
            myButton.setPadding(10,10,10,10);
        }
    }

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

    protected void setButtonParams(Button[] myButtons, LinearLayout.LayoutParams param){
        for(int i = 0; i < myButtons.length; i ++){
            myButtons[i].setLayoutParams(param);
        }
    }

    public boolean checkIfQuestionAnswered(){
        return correct;
    }
}

