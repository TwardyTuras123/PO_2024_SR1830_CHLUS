package agh.ics.oop.model;

import agh.ics.oop.model.util.Boundary;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap {

    private final Boundary boundary;

    public RectangularMap(int width, int height) {
        boundary = new  Boundary( new Vector2d(0, 0), new Vector2d(width - 1, height - 1));
    }


    @Override
    public Boundary getCurrentBoundary() {
        return boundary;
    }

}

