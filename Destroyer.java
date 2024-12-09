public class Destroyer extends Ship {
    /**
     * Constructs a Destroyer with a length of 2.
     */
    public Destroyer() {
        super(2);
    }

    @Override
    public String getShipType() {
        return "destroyer";
    }
}
