//Tutaj pisz sw
package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {
    @Test
    void testNextDir() {
        MapDirection n = MapDirection.NORTH;
        MapDirection e = MapDirection.EAST;
        MapDirection s = MapDirection.SOUTH;
        MapDirection w = MapDirection.WEST;

        assertEquals(n.next(), MapDirection.EAST);
        assertEquals(e.next(), MapDirection.SOUTH);
        assertEquals(s.next(), MapDirection.WEST);
        assertEquals(w.next(), MapDirection.NORTH);

    }

    @Test
    void testPreviousDir() {
        MapDirection n = MapDirection.NORTH;
        MapDirection e = MapDirection.EAST;
        MapDirection s = MapDirection.SOUTH;
        MapDirection w = MapDirection.WEST;

        assertEquals(n.previous(), MapDirection.WEST);
        assertEquals(e.previous(), MapDirection.NORTH);
        assertEquals(s.previous(), MapDirection.EAST);
        assertEquals(w.previous(), MapDirection.SOUTH);

    }

}