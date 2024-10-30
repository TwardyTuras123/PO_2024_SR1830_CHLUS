package agh.ics.oop.model;


public class Animal {

    private MapDirection direction;
    private Vector2d position;

    public Animal() {
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }

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
        return "Zwierze znajduję się na polu (%d, %d), I jest zwrócone na %s".formatted(position.getX(), position.getY(), direction.toString());
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    private boolean inBounds(Vector2d position) {
        return position.precedes(new Vector2d(4,4)) && position.follows(new Vector2d(0,0));
    }

    public void move(MoveDirection direction) {
        Vector2d movedVector;
        switch (direction) {
            case MoveDirection.RIGHT -> this.direction = this.direction.next();

            case MoveDirection.LEFT -> this.direction = this.direction.previous();

            case MoveDirection.FORWARD -> {

                movedVector = this.position.add(this.direction.toUnitVector());
                if (inBounds(movedVector)) {
                    this.position = movedVector;
                }
            }

            case MoveDirection.BACKWARD -> {
                movedVector = this.position.subtract(this.direction.toUnitVector());
                if (inBounds(movedVector)) {
                    this.position = movedVector;
                }
            }
        }
    }







}
