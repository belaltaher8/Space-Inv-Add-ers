package com.example.android.spaceinvadders.EntityComponent.Components;

/**
 * @author Belal Taher
 * Created on 8/15/2017.
 * The IComponent interface makes dealing with components much easier since an entity can simply hold a collection of
 * IComponents instead of having to have a specific reference for each kind of component that entity has
 */

public interface IComponent {

    public ComponentType getComponentType();
}
