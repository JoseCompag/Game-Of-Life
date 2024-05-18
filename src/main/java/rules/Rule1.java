package rules;

import boards.Board;
import cells.Cell;
import cells.LivingCell;

public class Rule1 extends Rule{

  public Rule1( Board board) {
    this.board = board;
  }

  @Override
  public boolean validate(Cell cell) {

    if(cell.getClass() != LivingCell.class){
      return false;
    }

    board.setNeighbors();
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
