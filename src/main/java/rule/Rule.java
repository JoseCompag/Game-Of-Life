package rule;

import board.Board;
import cell.Cell;

public abstract class Rule {

  public abstract boolean validate(Cell cell);
  public abstract Cell applyRule();
}
