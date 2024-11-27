package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.ConsoleMapDisplay;

import java.util.List;
import java.util.Map;

public class World {

    public static void main(String[] args) {

        try {
            GrassField grassMap = new GrassField(3);
            grassMap.addMapChangeObserver(new ConsoleMapDisplay());

            List<MoveDirection> directions = OptionsParser.parse(args);
            List<Vector2d> positions = List.of(new Vector2d(3, 5), new Vector2d(1, 5));
            Simulation simulation = new Simulation(positions, directions, grassMap);

            simulation.run();
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace(System.err);
        }
    }
}
