public class Cruiser extends Ship {
    /**
     * Constructs a Cruiser with a length of 3.
     */
    public Cruiser() {
        super(3);
    }

    @Override
    public String getShipType() {
        return "cruiser";
    }
}
