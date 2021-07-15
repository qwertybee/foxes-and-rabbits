package io.muic.ooc.fab.actor;

import io.muic.ooc.fab.field.Field;
import io.muic.ooc.fab.Location;

import java.util.HashMap;
import java.util.Map;

public class ActorFactory {

    private static Map<ActorType, Class> actorClassMap = new HashMap<>() {{
        ActorType[] actorTypes = ActorType.values();
        for (ActorType actorType : actorTypes) {
            put(actorType, actorType.getActorClass());
        }
    }};

    public static Actor createActor(ActorType actorType, Field field, Location location) {
        Class actorClass = actorClassMap.get(actorType);
        return createActor(actorClass, field, location);
    }

    public static Actor createActor(Class actorClass, Field field, Location location) {
        if (actorClass != null) {
            try {
                Actor animal = (Actor) actorClass.newInstance();
                animal.initialize(true, field, location);
                return animal;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        throw new IllegalArgumentException("Unknown actorType");
    }

}
