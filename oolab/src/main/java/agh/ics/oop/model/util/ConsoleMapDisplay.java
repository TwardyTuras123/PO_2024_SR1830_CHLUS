package agh.ics.oop.model.util;

import agh.ics.oop.model.MapChangeListener;
import agh.ics.oop.model.WorldMap;

public class ConsoleMapDisplay implements MapChangeListener {


    private int eventCounter = 1;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        System.out.println(message);
        System.out.println(worldMap);
        System.out.println("Event counter: " + eventCounter);
        System.out.println("---\n");
        eventCounter++;
    }
}
