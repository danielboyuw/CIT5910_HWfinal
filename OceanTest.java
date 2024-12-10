import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OceanTest {

    @Test
    public void testPlaceAllShipsRandomly() {
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();

        int shipCount = 0;
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                if (!(ocean.getShipArray()[row][col] instanceof EmptySea)) {
                    shipCount++;
                }
            }
        }

        assertEquals(20, shipCount);
    }

    @Test
    public void testShootAt() {
        Ocean ocean = new Ocean();
        Ship ship = new Battleship();
        ship.placeShipAt(2, 2, true, ocean);

        assertTrue(ocean.shootAt(2, 2));
        assertTrue(ocean.shootAt(2, 3));
        assertTrue(ocean.shootAt(2, 4));
        assertTrue(ocean.shootAt(2, 5));
        assertFalse(ocean.shootAt(2, 6));
    }




    @Test
    public void testIsGameOver() {
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ocean.shootAt(i, j);
            }
        }

        assertTrue(ocean.isGameOver());
    }

    @Test
    public void testPlaceAllShipsRandomly_noOverlapOrAdjacency() {
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();

        Ship[][] grid = ocean.getShipArray();

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                if (!(grid[row][col] instanceof EmptySea)) {

                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            int r = row + i;
                            int c = col + j;
                            if (r >= 0 && r < 10 && c >= 0 && c < 10) {
                                if (!(grid[r][c] instanceof EmptySea) && grid[r][c] != grid[row][col]) {
                                    fail("Ships are adjacent or overlapping at (" + row + ", " + col + ")");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
