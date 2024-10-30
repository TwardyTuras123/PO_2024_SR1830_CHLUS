package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final List<Animal> animals;
    private final List<MoveDirection> moves;

    public List<Animal> getAnimals() {
        return animals;
    }

    public Simulation(List<Vector2d> begPositions, List<MoveDirection> moveList) {
        this.animals = new ArrayList<>();
        this.moves = moveList;

        for (Vector2d position : begPositions) {
            animals.add(new Animal(position));
        }
    }

    public void run (){
        for (int i = 0; i < moves.size(); i++) {
            MoveDirection theMove = moves.get(i);
            Animal currentAnimal = animals.get(i % animals.size());
            currentAnimal.move(theMove);
            System.out.println("Zwierze" + i% animals.size() + ": " + currentAnimal.toString());
        }
    }
}
