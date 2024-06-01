package rule;

import cell.Cell;
import cell.LivingCell;

import java.util.ArrayList;
import java.util.List;

public class BirthRule extends Rule {

  private List<Integer> numOfLiveCellsForBirth;

  public BirthRule (List<Integer> params) {
    this.numOfLiveCellsForBirth = params;
  }

  @Override
  public boolean validate (Cell cell, List<Cell> cells) {
    if (cell.getClass() == LivingCell.class) {
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
