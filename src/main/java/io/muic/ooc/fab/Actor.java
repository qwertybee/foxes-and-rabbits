package io.muic.ooc.fab;

import java.util.List;

public abstract class Actor {
    // Whether the actor is alive or not.
    private boolean alive;

    // The actor's position.
    protected Location location;

    // The field occupied.
    protected Field field;

    public void initialize(boolean randomAge, Field field, Location location) {
        setAlive(true);
        this.field = field;
        setLocation(location);
    }

    /**
     * Check whether the actor is alive or not.
     *
     * @return true if the actor is still alive.
     */
    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * Place the actor at the new location in the given field.
     *
     * @param newLocation The actor's new location.
     */
    public void setLocation(Location newLocation) {
        if (location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

    protected abstract Location moveToNewLocation();

    /**
     * Return the actor's location.
     *
     * @return The actor's location.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Indicate that the actor is no longer alive. It is removed from the field.
     */
    protected void setDead() {
        setAlive(false);
        if (location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    protected abstract void act(List<Actor> newAnimals);

}
