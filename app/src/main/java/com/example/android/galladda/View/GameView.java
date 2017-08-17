package com.example.android.galladda.View;

import android.app.ActionBar;
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
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.android.galladda.EntityComponent.Components.ComponentType;
import com.example.android.galladda.EntityComponent.Components.PositionComponent;
import com.example.android.galladda.EntityComponent.Components.VelocityComponent;
import com.example.android.galladda.EntityComponent.Entities.AbstractEntity;
import com.example.android.galladda.EntityComponent.Entities.BulletEntity;
import com.example.android.galladda.EntityComponent.Entities.EntityManager;
import com.example.android.galladda.EntityComponent.Entities.EntityType;
import com.example.android.galladda.EntityComponent.Entities.PlayerEntity;
import com.example.android.galladda.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;
import static com.example.android.galladda.EntityComponent.Entities.EntityType.Bullet;
import static com.example.android.galladda.EntityComponent.Entities.EntityType.Player;


/**
 * Created by Belal Taher on 8/14/2017.
 */

public class GameView extends LinearLayout {

    private SurfaceView myGameScreen;
    private SurfaceHolder ourHolder;

    private Canvas myCanvas;
    private Paint myPaint;

    private EntityManager myEM;

    private Bitmap bitmapShip = BitmapFactory.decodeResource(this.getResources(), R.drawable.ship);
    private final Bitmap bitmapBullet = BitmapFactory.decodeResource(this.getResources(), R.drawable.bullet);

    public GameView(Context context, EntityManager aEM){
        super(context);
        setOrientation(LinearLayout.VERTICAL);
        setUpSurfaceView(context);
        setUpMovementPanel(context);
        myEM = aEM;
        createPlayerBitmap();
    }

    private void setUpSurfaceView(Context context){
        myGameScreen = new SurfaceView(context);
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                0,
                8.0f
        );
        myGameScreen.setLayoutParams(param);
        this.addView(myGameScreen);
        ourHolder = myGameScreen.getHolder();
        myPaint = new Paint();

    }

    private void setUpMovementPanel(Context context){
        LinearLayout movementPanel = new LinearLayout(context);
        LinearLayout.LayoutParams panelParam = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                0,
                1.0f
        );
        movementPanel.setLayoutParams(panelParam);
        movementPanel.setBackgroundColor(Color.RED);
        movementPanel.setOrientation(LinearLayout.HORIZONTAL);
        Button leftButton = new Button(context);
        Button rightButton = new Button(context);
        Button shootButton = new Button(context);
        LinearLayout.LayoutParams buttonParam = new LinearLayout.LayoutParams(
                0,
                LayoutParams.MATCH_PARENT,
                1.0f
        );
        leftButton.setLayoutParams(buttonParam);
        rightButton.setLayoutParams(buttonParam);
        shootButton.setLayoutParams(buttonParam);
        leftButton.setBackgroundColor(Color.GREEN);
        rightButton.setBackgroundColor(Color.RED);
        shootButton.setBackgroundColor(Color.BLACK);

        leftButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                VelocityComponent playerVC = (VelocityComponent) myEM.getPlayerOne().getComponent(ComponentType.Velocity);
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        playerVC.setX(-10);
                        return true; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        playerVC.setX(0);
                        return true; // if you want to handle the touch event
                }
                return false;
            }
        });

        rightButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                VelocityComponent playerVC = (VelocityComponent) myEM.getPlayerOne().getComponent(ComponentType.Velocity);
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        playerVC.setX(10);
                        return true; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        playerVC.setX(0);
                        return true; // if you want to handle the touch event
                }
                return false;
            }
        });

        shootButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BulletEntity newBullet = myEM.getPlayerOne().shoot();
                myEM.addBullet(newBullet);
            }

        });

        movementPanel.addView(leftButton);
        movementPanel.addView(shootButton);
        movementPanel.addView(rightButton);

        this.addView(movementPanel);
    }


    public void createPlayerBitmap(){
        bitmapShip = bitmapShip.createScaledBitmap(bitmapShip,150,150,false);
        PositionComponent playerPC = (PositionComponent) myEM.getPlayerOne().getComponent(ComponentType.Position);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        playerPC.setX(width/2-75);
        playerPC.setY(height/1.5f);
    }


    public void draw(){
        if(ourHolder.getSurface().isValid()) {
            myCanvas = ourHolder.lockCanvas();
            myCanvas.drawColor(Color.argb(255, 26, 128, 182));
            myPaint.setColor(Color.argb(255, 249, 129, 0));
            for (EntityType ET : EntityType.values()){

                ArrayList<AbstractEntity> entities = myEM.getEntitiesOfType(ET);

                for(int currentEntityToDrawIndex = 0; currentEntityToDrawIndex < entities.size(); currentEntityToDrawIndex++){
                    if(ET.equals(EntityType.Player)){
                        PlayerEntity player = (PlayerEntity) entities.get(currentEntityToDrawIndex);
                        PositionComponent playerPC = (PositionComponent) player.getComponent(ComponentType.Position);
                        myCanvas.drawBitmap(bitmapShip, playerPC.getX(), playerPC.getY(), myPaint);
                    }
                    if(ET.equals(Bullet)){
                        BulletEntity currentBullet = (BulletEntity) entities.get(currentEntityToDrawIndex);
                        PositionComponent bulletPC = (PositionComponent) currentBullet.getComponent(ComponentType.Position);
                        myCanvas.drawBitmap(bitmapBullet, bulletPC.getX(), bulletPC.getY() ,myPaint);
                    }
                }
            }
            ourHolder.unlockCanvasAndPost(myCanvas);
        }
    }


}
