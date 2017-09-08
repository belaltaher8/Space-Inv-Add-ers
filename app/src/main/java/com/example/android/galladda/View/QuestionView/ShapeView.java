package com.example.android.galladda.View.QuestionView;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Belal Taher on 8/25/2017.
 */

public class ShapeView extends QuestionView {

    private int answer;

    private String shape = "";
    private String operation = "";

    public ShapeView(Context myContext){
        super(myContext);
    }

    @Override
    protected void setUpQuestion() {
        int shapeToUse = rand.nextInt(3);
        if(shapeToUse == 0){
            shape = "Square";
        }
        else if (shapeToUse == 1){
            shape = "Triangle";
        }
        else if (shapeToUse == 2){
            shape = "Rectangle";
        }

        int operationToUse = rand.nextInt(2);
        if(operationToUse == 0){
            operation = "Perimeter";
        }
        else if (operationToUse == 1){
            operation = "Area";
        }
    }

    /**
     * This method sets up question screen
     * @param context context for this activity
     */
    protected void setUpQuestionScreen(Context context){
        super.setUpQuestionScreen(context);

        int sideLength = rand.nextInt(10)+1;

        //Sets the prompt text and equation text and adds it to the view
        questionText.setText("What is the answer to the following equation?");

        String equation = "";
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                0,
                2.0f
        );
        TextView equationText = new TextView(context);
        if(shape.equals("Square")){
            if(operation.equals("Perimeter")){
                equation = "What is the perimeter of a square where each side is " + sideLength + "?";
                answer = sideLength * 4;
            }
            else if(operation.equals("Area")){
                equation = "What is the area of a square where each side is " + sideLength + "?";
                answer = sideLength * sideLength;
            }
        }
        else if(shape.equals("Triangle")){
            if(operation.equals("Perimeter")){
                equation = "What is the perimeter of a triangle where each side is " + sideLength + "?";
                answer = sideLength * 3;
            }
            else if(operation.equals("Area")){
                if(sideLength%2 !=0){
                    sideLength = sideLength+1;
                }
                int height = rand.nextInt(10)+1;
                if(height%2 != 0){
                    height = height +1;
                }
                equation = "What is the area of a triangle where the base is " + sideLength + " and the height is " + height;
                answer = (sideLength*height)/2;
            }
        }
        else if(shape.equals("Rectangle")){
            int otherSideLength = rand.nextInt(10)+1;
            if(operation.equals("Perimeter")){
                equation = "What is the perimeter of a rectangle where one side is " + sideLength + " and the other is " + otherSideLength;
                answer = otherSideLength + otherSideLength + sideLength + sideLength;
            }
            else if(operation.equals("Area")){
                equation = "What is the rea of a rectangle where one side is " + sideLength + " and the other is " + otherSideLength;
                answer = otherSideLength * sideLength;
            }
        }

        equationText.setText(equation);
        equationText.setLayoutParams(param);
        equationText.setTextColor(Color.WHITE);
        equationText.setGravity(Gravity.CENTER);
        this.addView(equationText);

    }

    @Override
    /**
     * This method assigns generates false values for the answer buttons and assigns them to all but one button. That one
     * button is assigned the correct answer choice
     * @param myButtons an array containing all the answer buttons
     * @param correctChoice an int indicating which index of the myButtons array will be the button with the correct answer
     */
    protected void assignValuesToAnswerButtons(Button[] myButtons, int correctChoice){
        //Sets the text for the correct choice as the answer
        myButtons[correctChoice].setText("" + answer);
        int[] choicesUsed = new int[4];
        choicesUsed[correctChoice] = answer;
        //Iterates through the other answer buttons and adds a random offset between 1-10 to the answer to generate fake answers
        for(int i = 0; i < myButtons.length; i++){
            if(!(myButtons[i].getText().equals("" + answer))){

                int fakeAnswer;
                boolean repeat;
                do {
                    repeat = false;
                    int offset = rand.nextInt((10) + 1) - 5;
                    fakeAnswer = answer + offset;

                    for (int j = 0; j < choicesUsed.length; j++) {
                        if (choicesUsed[j] == fakeAnswer) {
                            repeat = true;
                        }
                    }
                }while(repeat);

                choicesUsed[i] = fakeAnswer;
                myButtons[i].setText("" + fakeAnswer);

            }
        }
    }
}
