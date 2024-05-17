package rules;

import gameOfLife.Board;
import cells.Cell;

public class Rule3 extends Rule{

  public Rule3(Cell cell, Board board) {
    this.cell = cell;
    this.board = board;
  }

  @Override
  public Cell validate() {
    return null;
  }
}
