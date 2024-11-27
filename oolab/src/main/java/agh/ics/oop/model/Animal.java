package agh.ics.oop.model;


public class Animal implements WorldElement {

    private MapDirection direction;
    private Vector2d position;
//    private Vector2d lowerLeft = new Vector2d(0, 0);
//    private Vector2d upperRight = new Vector2d(4, 4);


    public Animal(Vector2d position) {
        this.direction = MapDirection.NORTH;
        this.position = position;

    }

    public Animal( Vector2d position, MapDirection direction) {
        this.direction = direction;
        this.position = position;
    }



    public MapDirection getDirection() {
        return direction;
    }
    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return switch (direction) {
            case NORTH -> "^";
            case EAST -> ">";
            case SOUTH -> "v";
            case WEST -> "<";
        };
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

//    public boolean inBounds(Vector2d position, Vector2d lowerLeft, Vector2d upperRight) {
//        return position.precedes(upperRight) && position.follows(lowerLeft);
//    }

    public void move(MoveDirection direction, MoveValidator validator)  {
        Vector2d movedVector;
        switch (direction) {
            case MoveDirection.RIGHT -> this.direction = this.direction.next();

            case MoveDirection.LEFT -> this.direction = this.direction.previous();

            case MoveDirection.FORWARD -> {

                movedVector = this.position.add(this.direction.toUnitVector());
                if (validator.canMoveTo(movedVector)) {
                    this.position = movedVector;
                }
            }

            case MoveDirection.BACKWARD -> {
                movedVector = this.position.subtract(this.direction.toUnitVector());
                if (validator.canMoveTo(movedVector)) {
                    this.position = movedVector;
                }
            }
        }
    }







}
