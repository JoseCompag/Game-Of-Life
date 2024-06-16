package rule.ColourisedIMGame;

import cell.Cell;
import cell.ColourisedImGame.DeadCell;
import rule.Rule;

public class DeathRule extends Rule {

  public DeathRule() {}

  @Override
  public Cell apply(Cell cell) {
    return new DeadCell();
  }

}
