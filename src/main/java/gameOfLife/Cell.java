package gameOfLife;

public abstract class Cell {

    private int[] position;
    private Cell[] neighbors;

    public Cell () {
        position = null;
        neighbors = null;
    }

    public int[] getPosition() {
        return position;
    }

    public Cell[] getNeighbors() {
        return neighbors;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public void setNeighbors(Cell[] neighbors) {
        this.neighbors = neighbors;
    }
}
