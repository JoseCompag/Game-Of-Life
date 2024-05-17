package gameOfLife;

import cells.Cell;
import cells.DeadCell;

public class RectangularBoard extends Board{

  private Cell[][] board;
  private int width;
  private int height;

  public RectangularBoard(int width, int height) {
    this.width = width;
    this.height = height;
    board = new Cell[width][height];
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        board[x][y] = new DeadCell();
      }
    }
  }

  @Override
  public Board nextBoard() {
    return null;
  }

  @Override
  public String toString() {
    String res = "";
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        res += board[x][y].toString();
        res += "  ";
      }
      res += "\n";
    }
    return res;
  }
}
