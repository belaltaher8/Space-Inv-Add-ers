package com.example.android.galladda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

import com.example.android.galladda.GameController.GameController;
import com.example.android.galladda.View.GameView;

public class MainActivity extends AppCompatActivity {

    GameController gameController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameController = new GameController(this);
        setContentView(gameController.getGameView());
        SurfaceView myGameScreen = gameController.getGameView().getMyGameScreen();

        myGameScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameController.checkPlaying() == true){
                    gameController.pause();
                }
                else{
                    gameController.resume();
                }
            }
        });
    }

    public void onResume(){
        super.onResume();
        gameController.resume();
    }

    public void onPause(){
        super.onPause();
        gameController.pause();
    }

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
