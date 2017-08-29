package com.example.android.galladda.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.android.galladda.EntityComponent.Entities.Enum.EntityType;
import com.example.android.galladda.Controller.QuestionController.QuestionController;

/**
 * @author Belal Taher
 * Created on 8/24/2017.
 * The QuestionActivity class is the activity that starts when a challenge occurs. The view that the question controller initializes depends
 * on the type of challenge that is being executed.
 */

public class QuestionActivity extends AppCompatActivity {

    //The question controller makes sure the correct question view is loaded based on the type of challenge being currently executed
    private QuestionController myQuestionController;

    /**
     * This method is called on creation of the activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Unpacks the extra info in the intent that started this activity
        Intent intent = getIntent();
        String myChallengeString = intent.getStringExtra("Challenge Type");
        EntityType challengeType = null;

        //Compares the info in the intent with EntityType enums to see what kind of challenge this is
        for(EntityType CT : EntityType.values()){
            if(CT.name().equals(myChallengeString)){
                challengeType = CT;
                break;
            }
        }

        //Passes the type of challenge to the question controller so that it initializes the right kind of question view
        myQuestionController = new QuestionController(this, challengeType);

        //Sets the view of this activity as the view that the question controller constructed
        setContentView((View) myQuestionController.getMyQuestionView());
    }

    public void onResume(){
        super.onResume();
        myQuestionController.resume();
    }

    public void onPause(){
        super.onPause();
        myQuestionController.pause();
    }

    @Override
    public void onBackPressed(){
        return;
    }
}
