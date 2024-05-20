package rule;

import cell.Cell;
import cell.DeadCell;
import cell.LivingCell;

import java.util.List;

public class DeathRule extends Rule {

  public DeathRule() {}

  @Override
  public boolean validate (List<Cell> cells) {

    int count = 0;
    for (Cell c : cells) {
      if (c.getClass() == LivingCell.class) {
        count++;
      }
    }
    return count > 3 || count == 1 || count == 0;
  }

  @Override
  public Cell apply() {
    return new DeadCell();
  }

}
