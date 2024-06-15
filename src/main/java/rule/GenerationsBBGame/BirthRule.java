package rule.GenerationsBBGame;

import cell.Cell;
import cell.GenerationsBBGame.DeadCell;
import cell.GenerationsBBGame.LivingCell;
import rule.Rule;

import java.util.List;

public class BirthRule extends Rule {

  private List<Integer> numOfLiveCellsForBirth;

  public BirthRule (List<Integer> params) {
    this.numOfLiveCellsForBirth = params;
  }

  @Override
  public boolean validate (Cell cell, List<Cell> cells) {
    if (cell.getClass() != DeadCell.class) {
      return false;
    }
    int count = 0;
    for (Cell c : cells) {
      if (c.getClass() == LivingCell.class) {
        count++;
      }
    }
    for (Integer integer : numOfLiveCellsForBirth) {
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
