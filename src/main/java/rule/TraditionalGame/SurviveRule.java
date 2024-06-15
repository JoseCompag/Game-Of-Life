package rule.TraditionalGame;

import cell.Cell;
import cell.TraditionalGame.LivingCell;
import rule.Rule;

import java.util.List;

public class SurviveRule extends Rule {

  private List<Integer> numOfLiveCellsForSurvive;

  public SurviveRule (List<Integer> params) {
    this.numOfLiveCellsForSurvive = params;
  }

  @Override
  public boolean validate (Cell cell, List<Cell> cells) {
    if (cell.getClass() != LivingCell.class){
      return  false;
    }
    int count = 0;
    for (Cell c : cells) {
     if (c.getClass() == LivingCell.class) {
       count++;
     }
    }
    for (Integer integer : numOfLiveCellsForSurvive) {
      if (count == integer) {
        return true;
      }
    }
    return false;
  }

  @Override
  public Cell apply() {
    return new LivingCell();
  }

}
