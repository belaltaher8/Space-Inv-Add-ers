package com.example.android.galladda.EntityComponent.Entities;

import com.example.android.galladda.EntityComponent.Components.ComponentType;
import com.example.android.galladda.EntityComponent.Components.PositionComponent;

/**
 * Created by Belal Taher on 8/17/2017.
 */

public class EnemyEntity extends AbstractEntity {

    public EnemyEntity(){
        super();
        myComponents.put(ComponentType.Position, new PositionComponent(0,0));
    }
}
