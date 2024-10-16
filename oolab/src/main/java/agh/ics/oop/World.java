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
    }
}
