package board;

import cell.Cell;
import cell.DeadCell;
import rule.Rule;

import java.util.ArrayList;
import java.util.List;

public class RectangularBoard extends Board {

  private Cell[][] board;
  private int width;
  private int height;

  public RectangularBoard (int width, int height, List<Rule> rules) {
    this.width = width;
    this.height = height;
    this.rules = rules;
    board = new Cell[width][height];
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        board[x][y] = new DeadCell();
      }
    }
  }

  @Override
  public Board nextBoard () {
    RectangularBoard newBoard = new RectangularBoard(width, height, rules);
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        for (Rule rule : rules) {
          List<Cell> neighbors = calculateNeighbors(x, y);
          if (rule.validate(neighbors)) {
            newBoard.setCell(x,y,rule.apply());
            break;
          }
        }
      }
    }

    return newBoard;
  }

  private void setCell (int x, int y, Cell cell) {
    board[x][y] = cell;
  }

  /*
  private void setNeighbors() {
    ArrayList<Cell> aux;
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        aux = calculateNeighbors(x, y);
        board[x][y].setNeighbors(aux);
      }
    }
  }
  */
  private ArrayList<Cell> calculateNeighbors (int x, int y) {
    ArrayList<Cell> neighbors = new ArrayList<>();
    for (int i = x-1; i <= x+1; i++) {
      for (int j = y-1; j <= y+1; j++) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && (i != x || j != y)) {
          neighbors.add(board[i][j]);
        }
      }
    }
    return neighbors;
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
