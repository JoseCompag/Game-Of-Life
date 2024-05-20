package rule;

import cell.Cell;
import cell.DeadCell;
import cell.LivingCell;

public class DeathRule extends Rule {

  public DeathRule () {}

  @Override
  public boolean validate (Cell cell) {
    if (cell.getClass() == LivingCell.class) {
      return false;
    }
    int count = 0;
    for (Cell c : cell.getNeighbors()) {
      if (c.getClass() == LivingCell.class) {
        count++;
      }
    }
    return count > 3 || count == 1 || count == 0;
  }

  @Override
  public Cell apply() {
    return new DeadCell ();
  }

}
