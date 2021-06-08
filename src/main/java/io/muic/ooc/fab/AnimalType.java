package io.muic.ooc.fab;

public enum AnimalType {
    FOX(0.08, Fox.class),
    RABBIT(0.02, Rabbit.class);
//    TIGER()

    private double breedingProbability;

    private Class animalClass;

    AnimalType(double breedingProbability, Class animalClass) {
        this.breedingProbability = breedingProbability;
        this.animalClass = animalClass;
    }

    public double getBreedingProbability() {
        return breedingProbability;
    }

    public Class getAnimalClass() {
        return animalClass;
    }

}
