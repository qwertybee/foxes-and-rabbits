package io.muic.ooc.fab.field;

import io.muic.ooc.fab.Location;
import io.muic.ooc.fab.actor.Actor;
import io.muic.ooc.fab.actor.ActorFactory;
import io.muic.ooc.fab.actor.ActorType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class FieldPopulator {

    private static final Random RANDOM = new Random();

    private static Map<ActorType, Double> probabilityMap = new HashMap<>() {{
        ActorType[] actorTypes = ActorType.values();
        for (ActorType actorType : actorTypes) {
            put(actorType, actorType.getBreedingProbability());
        }
    }};

    /**
     * Randomly populate the field with foxes and rabbits.
     */
    public void populate(Field field, List<Actor> actors) {

        field.clear();
        for (int row = 0; row < field.getDepth(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                for (Map.Entry<ActorType, Double> entry : probabilityMap.entrySet()) {
                    if (RANDOM.nextDouble() <= entry.getValue()) {
                        Location location = new Location(row, col);
                        Actor actor = ActorFactory.createActor(entry.getKey(), field, location);
                        actors.add(actor);
                        break;
                    }
                }
            }
        }
    }

}
