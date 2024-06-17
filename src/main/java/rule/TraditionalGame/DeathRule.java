package rule.TraditionalGame;

import cell.Cell;
import cell.TraditionalGame.DeadCell;
import rule.Rule;

import java.util.HashMap;

public class DeathRule extends Rule {

  public DeathRule() {}

  @Override
  public boolean validate (Cell cell, HashMap<Class<?>, Integer> neighbors) {
    return true;
  }

  @Override
  public Cell apply(Cell cell, HashMap<Class<?>, Integer> neighbors) {
    return new DeadCell();
  }

}
