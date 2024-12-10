import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShipTest {

    @Test
    public void testPlaceShipAt() {
        Ocean ocean = new Ocean();
        Battleship battleship = new Battleship();

        assertTrue(battleship.okToPlaceShipAt(0, 0, true, ocean));
        battleship.placeShipAt(0, 0, true, ocean);

        assertEquals(battleship, ocean.getShipArray()[0][0]);
        assertEquals(battleship, ocean.getShipArray()[0][1]);
    }

    @Test
    public void testIsSunk() {
        Ocean ocean = new Ocean();
        Submarine submarine = new Submarine();
        submarine.placeShipAt(5, 5, true, ocean);

        assertTrue(ocean.shootAt(5, 5));
        assertTrue(submarine.isSunk());
    }

    @Test
    public void testOkToPlaceShipAt() {
        Ocean ocean = new Ocean();
        Destroyer destroyer = new Destroyer();

        assertTrue(destroyer.okToPlaceShipAt(3, 3, true, ocean));
        destroyer.placeShipAt(3, 3, true, ocean);
        assertFalse(destroyer.okToPlaceShipAt(3, 2, true, ocean));
        assertFalse(destroyer.okToPlaceShipAt(2, 3, false, ocean));
    }
}
