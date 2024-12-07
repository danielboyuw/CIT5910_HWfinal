public class Battleship extends Ship {
    /**
     * Constructs a Battleship with a length of 4.
     */
    public Battleship() {
        super(4);
    }

    @Override
    public String getShipType() {
        return "battleship";
    }
}
