package agh.ics.oop.model;

import agh.ics.oop.World;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap {
    protected final Vector2d lowerLeftEnd, upperRightEnd;
    private final Map<Vector2d, Animal> animalList = new HashMap<>();
    protected final MapVisualizer mapVisualizer = new MapVisualizer(this);

    public AbstractWorldMap(Vector2d lowerLeftEnd, Vector2d upperRightEnd) {
        this.lowerLeftEnd = lowerLeftEnd;
        this.upperRightEnd = upperRightEnd;
    }

    public AbstractWorldMap(){
        this(new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE), new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    public Vector2d getLowerLeftEnd() {
        return lowerLeftEnd;
    }
    public Vector2d getUpperRightEnd() {
        return upperRightEnd;
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            animalList.put(animal.getPosition(), animal);
            return true;
    }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        if (animalList.get(animal.getPosition()) == animal) {
            animalList.remove(animal.getPosition(), animal);
            animal.move(direction, this);
            animalList.put(animal.getPosition(), animal);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return(objectAt(position)!=null);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return animalList.get(position);
    }

    @Override
    public List<WorldElement> getElements() {
        return new ArrayList<>(List.copyOf(animalList.values()));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(upperRightEnd) && position.follows(lowerLeftEnd) && !isOccupied(position);
    }
}
