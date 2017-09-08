package com.example.android.galladda.View.GameView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.android.galladda.EntityComponent.Components.ComponentType;
import com.example.android.galladda.EntityComponent.Components.PositionComponent;
import com.example.android.galladda.EntityComponent.Components.VelocityComponent;
import com.example.android.galladda.EntityComponent.Entities.Explosion.ExplosionEntity;
import com.example.android.galladda.EntityComponent.Entities.General.AbstractEntity;
import com.example.android.galladda.EntityComponent.Entities.Bullets.GoodBulletEntity;
import com.example.android.galladda.EntityComponent.Entities.General.EntityManager;
import com.example.android.galladda.EntityComponent.Entities.Enum.EntityType;

import java.util.ArrayList;


/**
 * @author Belal Taher
 * Created on 8/14/2017.
 * The GameView class is the view that's loaded when the game is actually playing. It is the View component of the MVC Paradigm
 */

public class GameView extends LinearLayout {

    //The Surface view is where the "animation" takes place
    private SurfaceView myGameScreen;
    private SurfaceHolder ourHolder;

    //The canvas is attached to the surface view and it is where the bitmaps are drawn onto
    private Canvas myCanvas;
    private Paint myPaint;

    //Context for this activity
    Context myContext;

    //Entity manager so the class knows where to draw the entities on the canvas
    private EntityManager myEM;

    public GameView(Context context){
        super(context);
        myContext = context;
    }

    /**
     * This method attaches the entity manager to the game view. The entity manager originates in the model, so it's necessary
     * to attach it in a separate method instead of the constructor.
     * @param aEM the entity manager to be attached
     */
    public void attachEM(EntityManager aEM){
        myEM = aEM;
        initializeViews();
    }

    /**
     * This method is called as right after the entity manager is attached to the view. The game view cannot
     * initialize before this since it needs to get the bitmaps from the entity manager.
     */
    private void initializeViews(){
        //Sets orientation for the view
        setOrientation(LinearLayout.VERTICAL);

        //Sets up surface view on which the "animation" takes place
        setUpSurfaceView(myContext);

        //Sets up control buttons for player movement
        setUpMovementPanel(myContext);
    }

    /**
     * This method initializes the surface view on which the "animation" takes place
     * @param context context for this activity
     */
    private void setUpSurfaceView(Context context){

        //Creates surface view and specifies layout parameters
        myGameScreen = new SurfaceView(context);
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                0,
                8.0f
        );
        myGameScreen.setLayoutParams(param);

        //Attaches view to the surface view to the root
        this.addView(myGameScreen);
        ourHolder = myGameScreen.getHolder();
        myPaint = new Paint();

    }

    /**
     * This method initializes the control buttons for player movement
     * @param context context for this activity
     */
    private void setUpMovementPanel(Context context){

        //Sets aside space at the bottom of the screen for the buttons to be added to
        LinearLayout movementPanel = new LinearLayout(context);
        LinearLayout.LayoutParams panelParam = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                0,
                1.0f
        );
        movementPanel.setLayoutParams(panelParam);
        movementPanel.setBackgroundColor(Color.RED); //TODO: get rid of this
        movementPanel.setOrientation(LinearLayout.HORIZONTAL);

        //Constructs buttons and specifies layout parameters
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
        leftButton.setBackgroundColor(Color.GREEN); //TODO: get rid of this
        rightButton.setBackgroundColor(Color.RED);
        shootButton.setBackgroundColor(Color.BLACK);

        //Attaches on touch listener to left button
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

        //Attaches on touch listener to right button
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

        //Attaches on click listener to shoot button
        shootButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: FIX THIS SO THAT IT DOESNT SHOOT WHEN PAUSED
                GoodBulletEntity newBullet = myEM.getPlayerOne().shoot();
                myEM.addBullet(newBullet);
            }

        });

        //Adds all buttons to movement panel
        movementPanel.addView(leftButton);
        movementPanel.addView(shootButton);
        movementPanel.addView(rightButton);

        //Adds movement panel to the root
        this.addView(movementPanel);
    }


    /**
     * This method extracts the screen dimensions from the device. This is important since the player's & enemies' starting positions
     * and boundaries are based on the screen dimensions.
     * @return an 2D array with 2 indices, screenDimensions[0] is the width and screenDimensions[1] is the height
     */
    public int[] getScreenDimensions(){

        //Finds device dimensions
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        //Extracts height and width
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        //Saves the dimensions in a 2D array and returns the array
        int[] returningArray = new int[2];
        returningArray[0] = width;
        returningArray[1] = height;
        return returningArray;
    }

    /**
     * This method is called on every iteration of the main game loop. It handles updating the bitmaps' positions on the canvas.
     */
    public void draw(){

        //Checks if the surface view is valid
        if(ourHolder.getSurface().isValid()) {
            myCanvas = ourHolder.lockCanvas();
            myCanvas.drawColor(Color.argb(255, 26, 128, 182)); //TODO: get rid of this

            //Draws each entity in the entity manager based on its position coordinates
            for (EntityType ET : EntityType.values()){
                ArrayList<AbstractEntity> entities = myEM.getEntitiesOfType(ET);
                int currentEntityToDrawIndex = 0;
                while(currentEntityToDrawIndex < entities.size()){
                    AbstractEntity currentEntityToDraw = entities.get(currentEntityToDrawIndex);
                    PositionComponent myPC = (PositionComponent) currentEntityToDraw.getComponent(ComponentType.Position);

                    //Removes enemies that got killed and starts explosion animation
                    if( (ET.name().contains("Enemy") || ET.name().equals("Player")) && currentEntityToDraw.getExploding() == true){
                        ExplosionEntity myExplosion = new ExplosionEntity();
                        PositionComponent explosionPC = (PositionComponent) myExplosion.getComponent(ComponentType.Position);
                        explosionPC.setX(myPC.getX());
                        explosionPC.setY(myPC.getY());
                        myEM.addExplosion(myExplosion);
                    }
                    //If its an explosion, draw it according to the appropriate frame
                    else if(ET.name().equals("Explosion")){
                        ExplosionEntity myExplosionEntity = (ExplosionEntity) currentEntityToDraw;
                        Bitmap toDraw = BitmapFactory.decodeResource(this.myContext.getResources(), myExplosionEntity.getBitmapForFrame());
                        if(toDraw!=null){
                            myCanvas.drawBitmap(toDraw, myPC.getX(), myPC.getY(), myPaint);
                        }
                        currentEntityToDrawIndex++;
                    }
                    //Else draw regularly
                    else{
                        myCanvas.drawBitmap(myEM.getBitmap(ET), myPC.getX(), myPC.getY(), myPaint);
                        currentEntityToDrawIndex++;
                    }

                }
            }
            ourHolder.unlockCanvasAndPost(myCanvas);
        }
    }


}
