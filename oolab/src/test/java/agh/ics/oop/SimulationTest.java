package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
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

        //when
        Simulation simulation = new Simulation(positions, moves);
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
        //when
        Simulation simulation = new Simulation(positions, moves);
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
        //when
        Simulation simulation = new Simulation(positions, moves);
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

    }

