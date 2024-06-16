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
  public Cell apply(Cell cell) {
    return null;
  }

}
