package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> parse(String[] args){
        List<MoveDirection> moves = new ArrayList<>();
        for (String arg : args) {
            switch (arg) {
                case "l" -> moves.add(MoveDirection.LEFT);
                case "r" -> moves.add(MoveDirection.RIGHT);
                case "f" -> moves.add(MoveDirection.FORWARD);
                case "b" -> moves.add(MoveDirection.BACKWARD);
                default -> /*throw new IllegalArgumentException("Nie możesz sie poruszyć w " + arg)*/
                        System.out.println("cos");
            };


        }
        return moves;
    }


}
