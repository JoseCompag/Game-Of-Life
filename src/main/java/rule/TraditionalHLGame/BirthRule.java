package rule.TraditionalHLGame;

import cell.Cell;
import cell.TraditionalHLGame.DeadCell;
import cell.TraditionalHLGame.LivingCell;
import rule.Rule;

import java.util.List;

public class BirthRule extends Rule {

  public BirthRule () {  }

  @Override
  public Cell apply(Cell cell) {

    List<Cell> neighbors = this.cells.get(cell);

    if(cell.getClass() == DeadCell.class ){
      if (neighbors.size() == 3 || neighbors.size() == 6) {
        return new LivingCell();
      }
    }

    return cell;

  }

}
