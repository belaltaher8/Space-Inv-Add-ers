package com.example.android.galladda.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.android.galladda.EntityComponent.Entities.Enum.EntityType;
import com.example.android.galladda.Controller.QuestionController.QuestionController;

public class QuestionActivity extends AppCompatActivity {

    private QuestionController myQuestionController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String myChallengeString = intent.getStringExtra("Challenge Type");
        EntityType challengeType = null;
        for(EntityType CT : EntityType.values()){
            if(CT.name().equals(myChallengeString)){
                challengeType = CT;
                break;
            }
        }
        myQuestionController = new QuestionController(this, challengeType);
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
