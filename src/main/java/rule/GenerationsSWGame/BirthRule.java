package rule.GenerationsSWGame;

import cell.Cell;
import cell.GenerationsSWGame.DeadCell;
import cell.GenerationsSWGame.LivingCell;
import rule.Rule;

import java.util.List;

public class BirthRule extends Rule {

  private List<Integer> numOfLiveCellsForBirth;

  public BirthRule (List<Integer> params) {
    this.numOfLiveCellsForBirth = params;
  }

  @Override
  public Cell apply(Cell cell) {
    return null;
  }

}
