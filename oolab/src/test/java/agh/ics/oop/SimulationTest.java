package agh.ics.oop;

import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {
    @Test
    void testBoundaries() {
        //given
        List<Vector2d> positions = List.of(new Vector2d(0, 0));
        List<MoveDirection> moves = List.of(
                MoveDirection.BACKWARD,
                MoveDirection.LEFT,
                MoveDirection.FORWARD
        );
        RectangularMap map = new RectangularMap(4,4);

        //when
        Simulation simulation = new Simulation(positions, moves, map);
        simulation.run();
        Animal animal = simulation.getAnimals().get(0);

        //then
        assertTrue(animal.getPosition().getX() == 0 && animal.getPosition().getY() == 0);
    }

    @Test
    void isThePetTheRightOrientation() {
        //given
        List<Vector2d> positions = List.of(new Vector2d(0, 0), new Vector2d(1, 0), new Vector2d(2, 0));
        List<MoveDirection> moves = List.of(MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.RIGHT);
        RectangularMap map = new RectangularMap(4,4);
        //when
        Simulation simulation = new Simulation(positions, moves, map);
        simulation.run();
        //then
        List<Animal> animals = simulation.getAnimals();
        assertEquals(3, animals.size());

        Animal animal = simulation.getAnimals().get(0);
        Animal animal2 = simulation.getAnimals().get(1);
        Animal animal3 = simulation.getAnimals().get(2);
        assertTrue(animal.getDirection().equals(MapDirection.SOUTH));
        assertTrue(animal2.getDirection().equals(MapDirection.WEST));
        assertTrue(animal3.getDirection().equals(MapDirection.EAST));

        };

    @Test
    void isPetMovingCorrectly() {
        //given
        List<Vector2d> positions = List.of(new Vector2d(0, 0));
        List<MoveDirection> moves = List.of(MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD);
        RectangularMap map = new RectangularMap(4,4);
        //when
        Simulation simulation = new Simulation(positions, moves, map);
        simulation.run();
        //then
        Animal animal = simulation.getAnimals().get(0);
        assertTrue(animal.getPosition().getX() == 2 && animal.getPosition().getY() == 1);
    };

    @Test
    void testInputParsing() {
        //given
        String[] inputCommands = {"f", "b", "r", "l"};
        List<MoveDirection> parsedDirections = OptionsParser.parse(inputCommands);
        List<MoveDirection> expectedDirections = List.of(
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT,
                MoveDirection.LEFT
        );
        //then

        assertEquals(expectedDirections, parsedDirections);
    }

    @Test
    void testCollisionsBetweenAnimals() {
        //given
        List<Vector2d> positions = List.of(new Vector2d(0, 0), new Vector2d(1, 0));
        List<MoveDirection> moves = List.of(MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.FORWARD);
        RectangularMap map = new RectangularMap(4,4);

        //when
        Simulation simulation = new Simulation(positions, moves, map);
        simulation.run();

        //then
        Animal animal1 = simulation.getAnimals().get(0);
        Animal animal2 = simulation.getAnimals().get(1);
        assertTrue(animal1.getPosition().getX() == 0 && animal1.getPosition().getY() == 0);
        assertTrue(animal2.getPosition().getX() == 1 && animal2.getPosition().getY() == 0);

    }


    }

