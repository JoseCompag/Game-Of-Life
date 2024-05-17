package rules;

import gameOfLife.Board;
import cells.Cell;

public class Rule1 extends Rule{

  public Rule1(Cell cell, Board board) {
    this.cell = cell;
    this.board = board;
  }

  @Override
  public Cell validate() {
    return null;
  }
}
