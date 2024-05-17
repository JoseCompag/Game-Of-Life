package rules;

import gameOfLife.Board;
import cells.Cell;

public abstract class Rule {
  Cell cell;
  Board board;

  public abstract Cell validate();
}
