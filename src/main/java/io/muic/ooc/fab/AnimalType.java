package io.muic.ooc.fab;

public enum AnimalType {
    FOX(0.08), RABBIT(0.02);

    private double breedingProbability;

    AnimalType(double breedingProbability) {
        this.breedingProbability = breedingProbability;
    }

    public double getBreedingProbability() {
        return breedingProbability;
    }
}
