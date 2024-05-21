package rule;

import cell.Cell;
import cell.LivingCell;

import java.util.List;

public class SurviveRule extends Rule {

  private int numAOfLiveCellsForBirth;
  private int numBOfLiveCellsForBirth;

  public SurviveRule (int numAOfLiveCellsForBirth, int numBOfLiveCellsForBirth) {
    this.numAOfLiveCellsForBirth = numAOfLiveCellsForBirth;
    this.numBOfLiveCellsForBirth = numBOfLiveCellsForBirth;
  }

  @Override
  public boolean validate (List<Cell> cells) {
    int count = 0;
    for (Cell c : cells) {
     if (c.getClass() == LivingCell.class) {
       count++;
     }
    }
    return count == this.numAOfLiveCellsForBirth || count == this.numBOfLiveCellsForBirth ;
  }

  @Override
  public Cell apply() {
    return new LivingCell();
  }

}
