package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.List;

public class World {

    private static List<MoveDirection> directions;

    static void run(MoveDirection[] args)
    {
        for (MoveDirection arg : args)
            switch (arg) {
                case FORWARD ->  System.out.println("Do przodu");
                case BACKWARD ->  System.out.println("Do tyłu");
                case RIGHT ->  System.out.println("W prawo");
                case LEFT ->  System.out.println("W lewo");

        }
    }


    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println(animal);
        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
        Simulation simulation = new Simulation(positions, directions);
        simulation.run();
    }
}
