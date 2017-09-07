package com.example.android.galladda.EntityComponent.Entities.Enemies;

import com.example.android.galladda.EntityComponent.Components.AIComponent;
import com.example.android.galladda.EntityComponent.Components.ComponentType;
import com.example.android.galladda.EntityComponent.Components.PositionComponent;
import com.example.android.galladda.EntityComponent.Components.VelocityComponent;
import com.example.android.galladda.EntityComponent.Entities.Enum.EntityType;

/**
 * Created by Belal Taher on 8/25/2017.
 */

public class ShapeEnemyEntity extends AbstractEnemy {

    public ShapeEnemyEntity(){
        super();
        myEntityType = EntityType.ShapeEnemy;
    }
}
