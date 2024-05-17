package rules;

import gameOfLife.Board;
import cells.Cell;

public class Rule2 extends Rule{

  public Rule2(Cell cell, Board board) {
    this.cell = cell;
    this.board = board;
  }

  @Override
  public Cell validate() {
    return null;
  }
}
