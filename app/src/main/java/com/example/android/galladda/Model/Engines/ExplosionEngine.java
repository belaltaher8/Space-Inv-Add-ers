package com.example.android.galladda.Model.Engines;

import android.util.Log;

import com.example.android.galladda.EntityComponent.Components.ComponentType;
import com.example.android.galladda.EntityComponent.Components.FrameComponent;
import com.example.android.galladda.EntityComponent.Entities.Enum.EntityType;
import com.example.android.galladda.EntityComponent.Entities.General.AbstractEntity;
import com.example.android.galladda.EntityComponent.Entities.General.EntityManager;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

/**
 * Created by Belal Taher on 9/7/2017.
 */

public class ExplosionEngine extends AbstractEngine {

    public ExplosionEngine(EntityManager myEM){
        super(myEM);
    }

    @Override
    public void update() {
        ArrayList<AbstractEntity> myExplosions = myEM.getEntitiesOfType(EntityType.Explosion);
        int currentEntityToUpdate = 0;
        while(currentEntityToUpdate < myExplosions.size()){

            AbstractEntity myExplosionEntity = myExplosions.get(currentEntityToUpdate);
            FrameComponent myFC = (FrameComponent) myExplosionEntity.getComponent(ComponentType.Frame);
            myFC.nextFrame();

            if(myFC.isDone()){
                Log.d("DEBUG", "GETS HERE");
                myExplosions.remove(myExplosionEntity);
            }
            else{
                currentEntityToUpdate++;
            }
        }
    }
}
