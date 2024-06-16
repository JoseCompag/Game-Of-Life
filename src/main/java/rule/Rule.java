package rule;

import cell.Cell;

import java.util.HashMap;
import java.util.List;

public abstract class Rule {

  protected HashMap<Cell, List<Cell>> cells;

  public abstract Cell apply(Cell cell);
  public void setCells(HashMap<Cell, List<Cell>> cells) {
    this.cells = cells;
  }
}
