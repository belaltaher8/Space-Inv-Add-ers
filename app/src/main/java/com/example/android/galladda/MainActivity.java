package com.example.android.galladda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;

import com.example.android.galladda.GameController.GameController;

public class MainActivity extends AppCompatActivity {

    private GameController gameController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameController = new GameController(this);
        setContentView(gameController.getGameView());
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
