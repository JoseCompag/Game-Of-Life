package rule.GenerationsSWGame;

import cell.Cell;
import cell.GenerationsSWGame.LivingCell;
import rule.Rule;

import java.util.List;

public class SurviveRule extends Rule {

  private List<Integer> numOfLiveCellsForSurvive;

  public SurviveRule (List<Integer> params) {
    this.numOfLiveCellsForSurvive = params;
  }

  @Override
  public Cell apply(Cell cell) {
    return null;
  }

}
