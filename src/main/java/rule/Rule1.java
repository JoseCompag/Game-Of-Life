package rule;

import board.Board;
import cell.Cell;
import cell.LivingCell;

public class Rule1 extends Rule{

  public Rule1() {}

  @Override
  public boolean validate(Cell cell) {

    if(cell.getClass() != LivingCell.class){
      return false;
    }

    int count = 0;
    for (Cell c : cell.getNeighbors()) {
     if (c.getClass() == LivingCell.class) {
       count++;
     }
    }

    return count == 2 || count == 3;
  }

  @Override
  public Cell applyRule() {
    return new LivingCell();
  }
}
