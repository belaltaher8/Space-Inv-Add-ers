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
        myComponents.put(ComponentType.Position, new PositionComponent(0,0));
        myComponents.put(ComponentType.AI, new AIComponent());
        myComponents.put(ComponentType.Velocity, new VelocityComponent(0,0));
        myEntityType = EntityType.ShapeEnemy;
    }
}
