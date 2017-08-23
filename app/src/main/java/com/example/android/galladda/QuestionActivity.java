package com.example.android.galladda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.android.galladda.GameController.QuestionController.QuestionController;
import com.example.android.galladda.Model.Engines.ChallengeType;

public class QuestionActivity extends AppCompatActivity {

    private QuestionController myQuestionController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        myQuestionController = new QuestionController(this, ChallengeType.Math);
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
