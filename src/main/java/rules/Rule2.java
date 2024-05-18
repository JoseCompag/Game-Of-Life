package rules;

import boards.Board;
import cells.Cell;
import cells.DeadCell;
import cells.LivingCell;

public class Rule2 extends Rule{

  public Rule2() {
  }

  @Override
  public boolean validate(Cell cell) {

    if(cell.getClass() == LivingCell.class){
      return false;
    }

    int count = 0;
    for (Cell c : cell.getNeighbors()) {
      if (c.getClass() == LivingCell.class) {
        count++;
      }
    }

    return count < 2;
  }
  @Override
  public Cell applyRule() {
    return new DeadCell();
  }
}