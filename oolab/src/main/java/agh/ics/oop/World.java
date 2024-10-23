package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World {




    static void run(MoveDirection[] args)
    {
        for (MoveDirection arg : args)
            switch (arg) {
                case FORWARD ->  System.out.println("Do przodu");
                case BACKWARD ->  System.out.println("Do tyłu");
                case RIGHT ->  System.out.println("W prawo");
                case LEFT ->  System.out.println("W lewo");

        }
    }


    public static void main(String[] args) {
        System.out.println("system wystartował");
        run(OptionsParser.parse(args));
        System.out.println("system zakonczył dzialanie");

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        MapDirection dir = MapDirection.NORTH;
        System.out.println(dir);
        System.out.println(dir.next());
        System.out.println(dir.previous());
        System.out.println(dir.toString());
        System.out.println(dir.toUnitVector());


    }
}
