package io.muic.ooc.fab;

import java.awt.*;

public enum AnimalType {
    FOX(0.08, Fox.class, Color.BLUE),
    RABBIT(0.02, Rabbit.class, Color.ORANGE),
    TIGER(0.03,Tiger.class, Color.GREEN);

    private double breedingProbability;

    private Color color;

    private Class animalClass;

    AnimalType(double breedingProbability, Class animalClass, Color color) {
        this.breedingProbability = breedingProbability;
        this.animalClass = animalClass;
        this.color = color;
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

}
