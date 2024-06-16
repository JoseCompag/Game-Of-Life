package rule.TraditionalGame;

import cell.Cell;
import cell.TraditionalGame.DeadCell;
import cell.TraditionalGame.LivingCell;
import rule.Rule;

import java.util.ArrayList;
import java.util.List;

public class BirthRule extends Rule {

  public BirthRule () {
  }

  @Override
  public Cell apply(Cell cell) {

    List<Cell> neighbors = this.cells.get(cell);

    if(cell.getClass() == DeadCell.class){
      if (neighbors.size() == 3) {
        return new LivingCell();
      }
    }
    return cell;

  }

}
