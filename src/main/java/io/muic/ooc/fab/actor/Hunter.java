package io.muic.ooc.fab.actor;

import io.muic.ooc.fab.Location;

import java.util.List;

public class Hunter extends Actor{

    /**
     * This is what the hunter does most of the time: it hunts for rabbits tiger foxes. In the
     * process, it might breed, die of hunger, or die of old age.
     *
     * @param newAnimals A list to return newly born foxes and rabbits.
     */
    @Override
    public void act(List<Actor> newAnimals) {
        if (isAlive()) {
            // Try to move into a free location.
            Location newLocation = moveToNewLocation();
            if (newLocation != null) {
                setLocation(newLocation);
            } else {
                setLocation(getLocation());
            }
        }
    }

    @Override
    protected Location moveToNewLocation() {
        Location newLocation = findFood();
        if (newLocation == null) {
            // no food found - try to move to a free location
            newLocation = field.freeAdjacentLocation(getLocation());
        }
        return newLocation;
    }

    /**
     * Look for food adjacent to the current location. Only the first live
     * prey is eaten.
     *
     * @return Where food was found, or null if it wasn't.
     */
    private Location findFood() {
        List<Location> adjacent = field.adjacentLocations(location);
        for (Location where : adjacent) {
            Object animal = field.getObjectAt(where);
            if (animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if (rabbit.isAlive()) {
                    rabbit.setDead();
                    return where;
                }
            } else if (animal instanceof Fox) {
                Fox fox = (Fox) animal;
                if (fox.isAlive()) {
                    fox.setDead();
                    return where;
                }
            } else if (animal instanceof Tiger) {
                Tiger tiger = (Tiger) animal;
                if (tiger.isAlive()) {
                    tiger.setDead();
                    return where;
                }
            }
        }
        return null;
    }

}
