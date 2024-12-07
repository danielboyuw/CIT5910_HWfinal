public abstract class Ship {
    protected int length;
    protected int bowRow;
    protected int bowColumn;
    protected boolean horizontal;
    protected boolean[] hit;

    public Ship(int length) {
        this.length = length;
        this.hit = new boolean[length];
    }

    public int getLength() {
        return length;
    }

    public int getBowRow() {
        return bowRow;
    }

    public int getBowColumn() {
        return bowColumn;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }

    public void setBowColumn(int bowColumn) {
        this.bowColumn = bowColumn;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public abstract String getShipType();

    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        // 检查船是否超出边界
        if (horizontal) {
            if (column + length > 10) return false;
        } else {
            if (row + length > 10) return false;
        }

        // 检查周围区域是否安全（包括对角线）
        for (int i = -1; i <= length; i++) {
            for (int j = -1; j <= 1; j++) {
                int r = row + (horizontal ? j : i);
                int c = column + (horizontal ? i : j);
                if (r >= 0 && r < 10 && c >= 0 && c < 10) {
                    if (ocean.isOccupied(r, c)) return false;
                }
            }
        }

        return true;
    }

    public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        this.bowRow = row;
        this.bowColumn = column;
        this.horizontal = horizontal;

        for (int i = 0; i < length; i++) {
            if (horizontal) {
                ocean.ships[row][column + i] = this;
            } else {
                ocean.ships[row + i][column] = this;
            }
        }
    }

    public boolean shootAt(int row, int column) {
        if (isSunk()) return false;

        int index = horizontal ? column - bowColumn : row - bowRow;
        if (index >= 0 && index < length) {
            hit[index] = true;
            return true;
        }
        return false;
    }

    public boolean isSunk() {
        for (boolean h : hit) {
            if (!h) return false;
        }
        return true;
    }

    public boolean isHitAt(int row, int col) {
        // 如果船是水平放置
        if (horizontal) {
            if (row == bowRow && col >= bowColumn && col < bowColumn + length) {
                int index = col - bowColumn;
                return hit[index];
            }
        } else {
            // 如果船是垂直放置
            if (col == bowColumn && row >= bowRow && row < bowRow + length) {
                int index = row - bowRow;
                return hit[index];
            }
        }
        return false;
    }

}
