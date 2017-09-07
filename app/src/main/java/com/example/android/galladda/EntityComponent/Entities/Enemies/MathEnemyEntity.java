package com.example.android.galladda.EntityComponent.Entities.Enemies;

import android.content.Entity;

import com.example.android.galladda.EntityComponent.Components.AIComponent;
import com.example.android.galladda.EntityComponent.Components.ComponentType;
import com.example.android.galladda.EntityComponent.Components.PositionComponent;
import com.example.android.galladda.EntityComponent.Components.VelocityComponent;
import com.example.android.galladda.EntityComponent.Entities.Enum.EntityType;

/**
 * Created by Belal Taher on 8/17/2017.
 */

public class MathEnemyEntity extends AbstractEnemy {

    public MathEnemyEntity(){
        super();
        myEntityType = EntityType.MathEnemy;
    }
}
