package io.muic.ooc.fab;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Tiger extends Animal{
    // Characteristics shared by all tigers (class variables).

    // Random generator
    private static final Random RANDOM = new Random();
    // The tiger's food level, which is increased by eating rabbits.
    private int foodLevel;

    /**
     * Create a tiger. A tiger can be created as a new born (age zero and not
     * hungry) or with a random age and food level.
     * @param randomAge If true, the tiger will have random age and hunger level.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    @Override
    public void initialize(boolean randomAge, Field field, Location location) {
        super.initialize(randomAge, field, location);
        foodLevel = RANDOM.nextInt(ActorType.FOX.getFoodValue()+ ActorType.RABBIT.getFoodValue());
    }

    /**
     * This is what the tiger does most of the time: it hunts for rabbits and foxes. In the
     * process, it might breed, die of hunger, or die of old age.
     *
     * @param newActors A list to return newly born foxes and rabbits.
     */
    @Override
    public void act(List<Actor> newActors) {
        incrementHunger();
        super.act(newActors);
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
     * Make this tiger more hungry. This could result in the fox's death.
     */
    private void incrementHunger() {
        foodLevel -= 1;
        if (foodLevel <= 0) {
            setDead();
        }
    }

    /**
     * Look for rabbits adjacent to the current location. Only the first live
     * rabbit or fox is eaten.
     *
     * @return Where food was found, or null if it wasn't.
     */
    private Location findFood() {
        List<Location> adjacent = field.adjacentLocations(location);
        Iterator<Location> it = adjacent.iterator();
        while (it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if (animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if (rabbit.isAlive()) {
                    rabbit.setDead();
                    foodLevel = ActorType.RABBIT.getFoodValue();
                    return where;
                }
            }
            else if (animal instanceof Fox) {
                Fox fox = (Fox) animal;
                if (fox.isAlive()) {
                    fox.setDead();
                    foodLevel = ActorType.FOX.getFoodValue();
                    return where;
                }
            }
        }
        return null;
    }

    @Override
    public int getMaxAge() {
        return 300;
    }

    @Override
    protected double getBreedingProbability() {
        return 0.03;
    }

    @Override
    protected int getMaxLitterSize() {
        return 1;
    }

    @Override
    protected int getBreedingAge() {
        return 50;
    }

}
