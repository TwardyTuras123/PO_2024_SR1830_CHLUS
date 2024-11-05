package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap {
    public Map<Vector2d, Animal> animals = new HashMap<>();
    int width;
    int height;
    Vector2d lowerLeft;
    Vector2d upperRight;
    MapVisualizer visualizer;


    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        lowerLeft = new Vector2d(0, 0);
        upperRight = new Vector2d(this.width, this.height);
        this.visualizer = new MapVisualizer(this);
        this.animals = new HashMap<>();
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            System.out.println(animals);
            return true;
        }
        return false;
    }


    @Override
    public void move(Animal animal, MoveDirection direction) {
        System.out.println(animal + " moves " + direction);
        Vector2d oldPosition = animal.getPosition();
        animal.move(direction, this);
        animals.remove(oldPosition, animal);
        animals.put(animal.getPosition(), animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
//        System.out.println(objectAt(position));
//        System.out.println(animals);
        return objectAt(position) != null;
    }

    @Override
    public Animal objectAt(Vector2d position) {
        if (animals.containsKey(position)) {
            return animals.get(position);
        }
        return null;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(upperRight) && position.follows(lowerLeft) && !isOccupied(position);
    }

    @Override
    public String toString() {
        return visualizer.draw(lowerLeft, upperRight);
    }

}

