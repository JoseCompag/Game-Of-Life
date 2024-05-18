package rules;

import boards.Board;
import cells.Cell;

public abstract class Rule {

  public abstract boolean validate(Cell cell);
  public abstract Cell applyRule();
}
