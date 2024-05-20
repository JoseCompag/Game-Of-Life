package rule;

import cell.Cell;
import cell.LivingCell;

import java.util.List;

public class StayAliveRule extends Rule {

  public StayAliveRule() {}

  @Override
  public boolean validate (List<Cell> cells) {

    int count = 0;
    for (Cell c : cells) {
     if (c.getClass() == LivingCell.class) {
       count++;
     }
    }
    return count == 2 || count == 3;
  }

  @Override
  public Cell apply() {
    return new LivingCell();
  }

}
