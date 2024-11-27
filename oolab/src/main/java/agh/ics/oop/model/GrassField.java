package agh.ics.oop.model;
import agh.ics.oop.model.util.MapVisualizer;

import java.lang.Math;
import java.util.*;

public class GrassField extends AbstractWorldMap {
    private final Map<Vector2d, Grass> grassMap = new HashMap<>();

    public GrassField(int grassAmount) {
        super();
        int grassBoardSize = (int) Math.sqrt(10 * grassAmount);
        Random rand = new Random();
        while (grassMap.size() < grassAmount) {
            int x = rand.nextInt(grassBoardSize + 1);
            int y = rand.nextInt(grassBoardSize + 1);
            Vector2d position = new Vector2d(x, y);
            if (!grassMap.containsKey(position)) {
                grassMap.put(position, new Grass(position));
            }
        }

    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        WorldElement animal = super.objectAt(position);
        if (animal != null) {
            return animal;
        }
        return grassMap.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (objectAt(position) instanceof Animal) {
            return false;
        }
        return true;
    }

    @Override
    public List<WorldElement> getElements() {
        List<WorldElement> elements = super.getElements();
        elements.addAll(List.copyOf(grassMap.values()));
        return elements;
    }

    @Override
    public String toString() {
        List<WorldElement> elements = getElements();
        if (elements.isEmpty()) {
            return "";
        }
        Vector2d topRight = elements.getFirst().getPosition();
        Vector2d bottomLeft = elements.getFirst().getPosition();

        for (WorldElement element : elements) {
            topRight = topRight.upperRight(element.getPosition());
            bottomLeft = bottomLeft.lowerLeft(element.getPosition());
        }

        return mapVisualizer.draw(bottomLeft, topRight);
    }
}
