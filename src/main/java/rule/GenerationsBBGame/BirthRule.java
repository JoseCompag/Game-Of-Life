package rule.GenerationsBBGame;

import cell.Cell;
import cell.GenerationsBBGame.DeadCell;
import cell.GenerationsBBGame.LivingCell;
import rule.Rule;

import java.util.HashMap;

public class BirthRule extends Rule {

  public BirthRule() {}

  @Override
  public boolean validate (Cell cell, HashMap<Class<?>, Integer> neighbors) {
    if (cell.getClass() != DeadCell.class) {
      return false;
    }
    if (neighbors.get(LivingCell.class) == 2) {
      return true;
    }
    return false;
  }

  @Override
  public Cell apply(Cell cell, HashMap<Class<?>, Integer> neighbors) {
    return new LivingCell();
  }

}
