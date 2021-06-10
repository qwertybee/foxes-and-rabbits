package io.muic.ooc.fab;

import java.awt.*;

public enum AnimalType {
    FOX(0.08, Fox.class, Color.BLUE, 20),
    RABBIT(0.02, Rabbit.class, Color.ORANGE, 9),
    TIGER(0.03,Tiger.class, Color.GREEN, 50),
    HUNTER(0.001, Hunter.class, Color.RED, 0);

    private double breedingProbability;

    private Color color;

    private Class animalClass;

    private int foodValue;

    AnimalType(double breedingProbability, Class animalClass, Color color, int foodValue) {
        this.breedingProbability = breedingProbability;
        this.animalClass = animalClass;
        this.color = color;
        this.foodValue = foodValue;
    }

    public double getBreedingProbability() {
        return breedingProbability;
    }

    public Class getAnimalClass() {
        return animalClass;
    }

    public Color getColor() {
        return color;
    }

    public int getFoodValue() { return foodValue; }

}
