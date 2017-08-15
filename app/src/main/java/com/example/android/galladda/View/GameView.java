package com.example.android.galladda.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Belal Taher on 8/14/2017.
 */

public class GameView extends SurfaceView implements Runnable {

    private Thread gameThread = null;
    private SurfaceHolder ourHolder;
    private volatile boolean playing;

    private Canvas myCanvas;
    private Paint myPaint;

    long fps;

    private long timeThisFrame;

    public GameView(Context context){
        super(context);
        ourHolder = getHolder();
        myPaint = new Paint();
    }

    public void run(){
        while (playing){
            long startFrameTime = System.currentTimeMillis();
            update();
            draw();
            timeThisFrame = System.currentTimeMillis() - startFrameTime;
            if(timeThisFrame > 0){
                fps = 1000/timeThisFrame;
            }
        }
    }

    public void update(){

    }

    public void draw(){

    }

}
