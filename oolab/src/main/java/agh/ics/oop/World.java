package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;
import java.util.Map;

public class World {

    public static void main(String[] args) {

        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(3, 5), new Vector2d(1, 5));
        GrassField grassMap = new GrassField(3);
        Simulation simulation = new Simulation(positions, directions, grassMap);

        simulation.run();
    }
}
