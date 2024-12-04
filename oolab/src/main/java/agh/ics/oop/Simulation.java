package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.WorldMap;
import agh.ics.oop.model.util.IncorrectPositionException;

import java.util.ArrayList;
import java.util.List;

public class Simulation implements Runnable {
    private final List<Animal> animals = new ArrayList<>();
    private final List<MoveDirection> moves;
    private final WorldMap worldMap;

    public List<Animal> getAnimals() {
        return animals;
    }

    public Simulation(List<Vector2d> begPositions, List<MoveDirection> moveList, WorldMap map) {
        worldMap = map;
        moves = moveList;

        for (Vector2d position : begPositions) {
            Animal newAnimal = new Animal(position);

            try {
                map.place(newAnimal);
                animals.add(newAnimal);
            }
            catch (IncorrectPositionException e) {
                e.printStackTrace(System.err);
            }

        }
        System.out.println(animals);
    }

    public void run (){
        for (int i = 0; i < moves.size(); i++) {
            worldMap.move(animals.get(i % animals.size()), moves.get(i));
        }
    }
}
