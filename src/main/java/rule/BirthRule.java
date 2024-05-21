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
  public boolean validate (List<Cell> cells) {
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
