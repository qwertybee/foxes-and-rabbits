package io.muic.ooc.fab;

import java.awt.*;

public enum ActorType {
    FOX(0.08, Fox.class, Color.BLUE, 20),
    RABBIT(0.02, Rabbit.class, Color.ORANGE, 9),
    TIGER(0.05,Tiger.class, Color.GREEN, 50),
    HUNTER(0.003, Hunter.class, Color.RED, 0);

    private double breedingProbability;

    private Color color;

    private Class actorClass;

    private int foodValue;

    ActorType(double breedingProbability, Class actorClass, Color color, int foodValue) {
        this.breedingProbability = breedingProbability;
        this.actorClass = actorClass;
        this.color = color;
        this.foodValue = foodValue;
    }

    public double getBreedingProbability() {
        return breedingProbability;
    }

    public Class getActorClass() {
        return actorClass;
    }

    public Color getColor() {
        return color;
    }

    public int getFoodValue() { return foodValue; }

}
