package com.example.android.galladda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.galladda.GameController.QuestionController.QuestionController;

public class QuestionActivity extends AppCompatActivity {

    private QuestionController myQuestionController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        myQuestionController = new QuestionController(this, );
    }

   /* @Override
    public void onBackPressed(){
        return;
    }*/
}
