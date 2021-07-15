package io.muic.ooc.fab.actor;

import io.muic.ooc.fab.Location;

import java.util.List;

public class Rabbit extends Animal {

    @Override
    protected Location moveToNewLocation() {
        return field.freeAdjacentLocation(getLocation());
    }

    /**
     * This is what the rabbit does most of the time - it runs around. Sometimes
     * it will breed or die of old age.
     *
     * @param newActors A list to return newly born rabbits.
     */
    @Override
    public void act(List<Actor> newActors) {
        super.act(newActors);
    }

    @Override
    protected double getBreedingProbability() {
        return 0.12;
    }

    @Override
    protected int getMaxLitterSize() {
        return 4;
    }

    @Override
    public int getMaxAge() {
        return 40;
    }

    @Override
    protected int getBreedingAge() {
        return 5;
    }

}
