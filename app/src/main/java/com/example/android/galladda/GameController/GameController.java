package com.example.android.galladda.GameController;

import android.content.Context;

import com.example.android.galladda.Model.GameModel;
import com.example.android.galladda.View.GameView;

/**
 * Created by Belal Taher on 8/15/2017.
 */

public class GameController {

    GameView myGameView;
    GameModel myGameModel;

    public GameController(Context context){
        myGameView = new GameView(context);
        myGameModel = new GameModel();
    }

    public GameView getGameView(){
        return myGameView;
    }

    public GameModel getGameModel(){
        return myGameModel;
    }

}

