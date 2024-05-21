package rule;

import cell.Cell;
import cell.DeadCell;

import java.util.List;

public class DeathRule extends Rule {

  public DeathRule() {}

  @Override
  public boolean validate (List<Cell> cells) {
    return true;
  }

  @Override
  public Cell apply() {
    return new DeadCell();
  }

}
