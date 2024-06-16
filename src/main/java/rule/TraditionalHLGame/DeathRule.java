package rule.TraditionalHLGame;

import cell.Cell;
import cell.TraditionalHLGame.DeadCell;
import rule.Rule;

import java.util.List;

public class DeathRule extends Rule {

  public DeathRule() {}

  @Override
  public Cell apply(Cell cell) {
    return new DeadCell();
  }

}
