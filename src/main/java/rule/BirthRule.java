package rule;

import cell.Cell;
import cell.LivingCell;

public class BirthRule extends Rule {

  public BirthRule() {}

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
    return count == 3;
  }

  @Override
  public Cell apply() {
    return new LivingCell();
  }

}
