package rule.TraditionalGame;

import cell.Cell;
import cell.TraditionalGame.LivingCell;
import rule.Rule;

import java.util.HashMap;

public class SurviveRule extends Rule {

  public SurviveRule () {}

  @Override
  public boolean validate (Cell cell, HashMap<Class<?>, Integer> neighbors) {
    if (cell.getClass() != LivingCell.class){
      return  false;
    }
    if (neighbors.get(LivingCell.class) == 2 || neighbors.get(LivingCell.class) == 3) {
      return true;
    }
    return false;
  }

  @Override
  public Cell apply(Cell cell, HashMap<Class<?>, Integer> neighbors) {
    return new LivingCell();
  }

}
