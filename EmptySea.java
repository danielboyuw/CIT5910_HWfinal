public class EmptySea extends Ship {
    /**
     * Constructs an EmptySea object with a length of 1.
     */
    public EmptySea() {
        super(1);
    }

    @Override
    public String getShipType() {
        return "empty";
    }

    /**
     * EmptySea is never "hit" in the sense of gameplay logic, so this always
     * returns false.
     */
    @Override
    public boolean shootAt(int row, int column) {
        return false;
    }

    /**
     * EmptySea is never "sunk" in the sense of gameplay logic, so this always
     * returns false.
     */
    @Override
    public boolean isSunk() {
        return false;
    }

    @Override
    public boolean isHitAt(int row, int col) {
        // EmptySea 不需要依赖 hit 数组，只需返回 false
        return false;
    }

}
