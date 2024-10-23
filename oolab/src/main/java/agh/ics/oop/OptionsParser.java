package agh.ics.oop;


import agh.ics.oop.model.MoveDirection;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args){
        int argsLength = args.length;
        MoveDirection[] moves = new MoveDirection[argsLength];
        int j = 0;
        for (int i = 0; i < argsLength; i++) {
            switch (args[i]) {
                case "l" -> moves[i-j] = MoveDirection.LEFT;
                case "r" -> moves[i-j] = MoveDirection.RIGHT;
                case "b" -> moves[i-j] = MoveDirection.BACKWARD;
                case "f" -> moves[i-j] = MoveDirection.FORWARD;
                default -> j++;
            };


        }
        return Arrays.copyOfRange(moves, 0, argsLength-j);
    }


}
