package rule.ColourisedQLGame;

import cell.Cell;
import cell.ColourisedQLGame.DeadCell;
import rule.Rule;

import java.util.List;

public class DeathRule extends Rule {

  public DeathRule() {}

  @Override
  public Cell apply(Cell cell) {
    return new DeadCell();
  }

}
