package com.example.android.galladda.View.QuestionView;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Belal Taher on 8/19/2017.
 */

public class MathView extends LinearLayout implements QuestionView {

    private int answer;
    private int firstNum;
    private int secondNum;

    private boolean correct;

    Random rand;

    private String operatorSymbol;

    public MathView(Context context){
        super(context);
        setUpQuestion();
        setUpQuestionScreen(context);
        setUpAnswerButtons(context);
        correct = false;
    }

    public void setUpQuestion(){
        rand = new Random();
        firstNum = rand.nextInt(21);
        secondNum = rand.nextInt(21);
        int operation = rand.nextInt(3);
        if(operation == 0){  //ADDITION
            answer = firstNum + secondNum;
            operatorSymbol = " + ";
        }
        if(operation == 1) { //SUBTRACTION
            answer = firstNum - secondNum;
            operatorSymbol = " - ";
        }
        if(operation == 2){ //MULTIPLICATION
            answer = firstNum * secondNum;
            operatorSymbol = " * ";
        }
    }

    public void setUpQuestionScreen(Context context){
        setOrientation(LinearLayout.VERTICAL);
        setOrientation(LinearLayout.VERTICAL);
        TextView questionText = new TextView(context);
        questionText.setText("What is the answer the following question?");
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                0,
                2.0f
        );
        questionText.setLayoutParams((param));
        this.addView(questionText);
        String equation = firstNum + operatorSymbol + secondNum;
        TextView equationText = new TextView(context);
        equationText.setText(equation);
        equationText.setLayoutParams(param);
        this.addView(equationText);
    }

    public void setUpAnswerButtons(Context myContext){
        Button choiceOne = new Button(myContext);
        Button choiceTwo = new Button(myContext);
        Button choiceThree = new Button(myContext);
        Button choiceFour = new Button(myContext);
        int correctChoice = rand.nextInt(4);
        Button[] myButtons = new Button[4];
        myButtons[0] = choiceOne;
        myButtons[1] = choiceTwo;
        myButtons[2] = choiceThree;
        myButtons[3] = choiceFour;
        assignValuesToAnswerButtons(myButtons, correctChoice);
        assignOnClickTowAnswerButtons(myButtons, correctChoice);
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                0,
                2.0f
        );
        setButtonParams(myButtons, param);
        this.addView(choiceOne);
        this.addView(choiceTwo);
        this.addView(choiceThree);
        this.addView(choiceFour);
    }

    public void setButtonParams(Button[] myButtons, LayoutParams param){
        for(int i = 0; i < myButtons.length; i ++){
            myButtons[i].setLayoutParams(param);
        }
    }

    public void assignValuesToAnswerButtons(Button[] myButtons, int correctChoice){

        myButtons[correctChoice].setText("" + answer);
        for(int i = 0; i < myButtons.length; i++){
            if(!(myButtons[i].getText().equals("" + answer))){
                myButtons[i].setText("" + 5);
            }
        }
    }

    public void assignOnClickTowAnswerButtons(Button[] myButtons, int correctChoice){
        myButtons[correctChoice].setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                correct = true;
            }
        });
    }

    public boolean checkIfQuestionAnswered(){
        return correct;
    }
}
