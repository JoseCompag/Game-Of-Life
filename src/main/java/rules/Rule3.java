package rules;

import boards.Board;
import cells.Cell;
import cells.LivingCell;

public class Rule3 extends Rule{

  public Rule3() {}

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

    return count == 3;
  }

  @Override
  public Cell applyRule() {
    return new LivingCell();
  }
}
