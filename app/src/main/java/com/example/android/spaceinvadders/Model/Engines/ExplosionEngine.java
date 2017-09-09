package com.example.android.spaceinvadders.Model.Engines;

import com.example.android.spaceinvadders.EntityComponent.Components.ComponentType;
import com.example.android.spaceinvadders.EntityComponent.Components.FrameComponent;
import com.example.android.spaceinvadders.EntityComponent.Entities.Enum.EntityType;
import com.example.android.spaceinvadders.EntityComponent.Entities.General.AbstractEntity;
import com.example.android.spaceinvadders.EntityComponent.Entities.General.EntityManager;

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
                myExplosions.remove(myExplosionEntity);
            }
            else{
                currentEntityToUpdate++;
            }
        }
    }
}
