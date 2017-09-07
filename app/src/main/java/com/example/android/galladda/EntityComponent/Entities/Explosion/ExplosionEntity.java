package com.example.android.galladda.EntityComponent.Entities.Explosion;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

import com.example.android.galladda.EntityComponent.Components.ComponentType;
import com.example.android.galladda.EntityComponent.Components.FrameComponent;
import com.example.android.galladda.EntityComponent.Components.PositionComponent;
import com.example.android.galladda.EntityComponent.Entities.Enum.EntityType;
import com.example.android.galladda.EntityComponent.Entities.General.AbstractEntity;
import com.example.android.galladda.R;

/**
 * Created by Belal Taher on 9/7/2017.
 */

public class ExplosionEntity extends AbstractEntity {

    public static final boolean DO_NOT_REPEAT = false;
    public static final int NUM_OF_FRAMES = 12;


    public ExplosionEntity() {
        super();
        myComponents.put(ComponentType.Frame, new FrameComponent(NUM_OF_FRAMES, DO_NOT_REPEAT));
        myEntityType = EntityType.Explosion;
    }


    public int getBitmapForFrame() {
        FrameComponent myFC = (FrameComponent) myComponents.get(ComponentType.Frame);
        if (myFC.getFrame() == 1) {
            return R.drawable.explosion1;
        }
        else if (myFC.getFrame() == 2){
            return R.drawable.explosion2;
        }
        else if (myFC.getFrame() == 3){
            return R.drawable.explosion3;
        }
        else if (myFC.getFrame() == 4){
            return R.drawable.explosion4;
        }
        else if (myFC.getFrame() == 5){
            return R.drawable.explosion5;
        }
        else if (myFC.getFrame() == 6){
            return R.drawable.explosion6;
        }
        else if (myFC.getFrame() == 7){
            return R.drawable.explosion7;
        }
        else if(myFC.getFrame() == 8){
            return R.drawable.explosion8;
        }
        else if(myFC.getFrame() ==9){
            return R.drawable.explosion9;
        }
        else if(myFC.getFrame() == 10){
            return R.drawable.explosion10;
        }
        else{
            return R.drawable.explosion11;
        }


    }
}
