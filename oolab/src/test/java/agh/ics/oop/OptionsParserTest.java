package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {
    @Test
    void testParseCorrectInputs() {
        //given
        String[] args = {"f", "b", "l", "r"};
        //when
        List<MoveDirection> expectedMoves = List.of(
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.LEFT,
                MoveDirection.RIGHT
        );
        List<MoveDirection> actualMoves = OptionsParser.parse(args);
        //then
        assertEquals(expectedMoves, actualMoves);
    }

    @Test
    void testParseWrongInputs() {
        String[] args = {"f", "b", "l", "r", "x"};
        assertThrows(IllegalArgumentException.class, () -> OptionsParser.parse(args));

    }
}