package rule;

import cell.Cell;
import cell.LivingCell;

import java.util.List;

public class BirthRule extends Rule {

  private int numOfLiveCellsForBirth;

  public BirthRule (int numOfLiveCellsForBirth) {
    this.numOfLiveCellsForBirth = numOfLiveCellsForBirth;
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
    return count == this.numOfLiveCellsForBirth;
  }

  @Override
  public Cell apply() {
    return new LivingCell();
  }

}
