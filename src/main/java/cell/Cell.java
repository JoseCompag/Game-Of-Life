package cell;

import java.util.ArrayList;

public abstract class Cell {

    private ArrayList<Cell> neighbors;

    public Cell () {
        neighbors = new ArrayList<>();
    }

    public ArrayList<Cell> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(ArrayList<Cell> neighbors) {
        this.neighbors = neighbors;
    }

}
