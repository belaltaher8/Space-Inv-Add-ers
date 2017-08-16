package com.example.android.galladda.View;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.location.Location;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.android.galladda.EntityComponent.Components.ComponentType;
import com.example.android.galladda.EntityComponent.Components.PositionComponent;
import com.example.android.galladda.EntityComponent.Components.VelocityComponent;
import com.example.android.galladda.EntityComponent.Entities.EntityManager;
import com.example.android.galladda.R;

import static android.R.attr.bitmap;

/**
 * Created by Belal Taher on 8/14/2017.
 */

public class GameView extends SurfaceView {

    private SurfaceHolder ourHolder;

    private Canvas myCanvas;
    private Paint myPaint;

    private EntityManager myEM;

    private Bitmap bitmapShip;

    public GameView(Context context, EntityManager aEM){
        super(context);
        ourHolder = getHolder();
        myPaint = new Paint();
        myEM = aEM;
        createPlayerView();
    }

    private void createPlayerView(){
        bitmapShip = BitmapFactory.decodeResource(this.getResources(), R.drawable.ship);
        bitmapShip = bitmapShip.createScaledBitmap(bitmapShip,150,150,false);
        PositionComponent playerPC = (PositionComponent) myEM.getPlayerOne().getComponent(ComponentType.Position);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        playerPC.setX(width/2-75);
        playerPC.setY(height/1.3f);
    }


    public void draw(){
        if(ourHolder.getSurface().isValid()){
            myCanvas = ourHolder.lockCanvas();
            myCanvas.drawColor(Color.argb(255,26,128,182));
            myPaint.setColor(Color.argb(255,249,129,0));
            PositionComponent playerPC = (PositionComponent) myEM.getPlayerOne().getComponent(ComponentType.Position);
            myCanvas.drawBitmap(bitmapShip, playerPC.getX(), playerPC.getY(), myPaint);
            ourHolder.unlockCanvasAndPost(myCanvas);
        }
    }


    public boolean onTouchEvent(MotionEvent motionEvent){
        VelocityComponent playerVC = (VelocityComponent) myEM.getPlayerOne().getComponent(ComponentType.Velocity);
        switch(motionEvent.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_DOWN:
                playerVC.setX(10);
                break;

            case MotionEvent.ACTION_UP:
                playerVC.setX(0);
                break;
        }
        return true;
    }

}
