package rule.TraditionalGame;

import cell.Cell;
import cell.TraditionalGame.DeadCell;
import cell.TraditionalGame.LivingCell;
import rule.Rule;

import java.util.List;

public class SurviveRule extends Rule {

  public SurviveRule () {  }

  @Override
  public Cell apply(Cell cell) {

    List<Cell> neighbors = this.cells.get(cell);

    if (cell.getClass() == LivingCell.class) {
      if (neighbors.size() == 2 || neighbors.size() == 3) {
        return cell;
      }
    }

    return new DeadCell();

  }

}
