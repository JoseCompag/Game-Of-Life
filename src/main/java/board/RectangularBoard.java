package board;

import cell.*;
import rule.Rule;

import java.util.ArrayList;
import java.util.List;

public class RectangularBoard extends Board {

  private Cell[][] board;
  private int rows;
  private int cols;

  public RectangularBoard (int rows, int cols, List<Rule> rules) {
    this.rows = rows;
    this.cols = cols;
    this.rules = rules;
    board = new Cell[rows][cols];
    for (int x = 0; x < rows; x++) {
      for (int y = 0; y < cols; y++) {
        board[x][y] = new DeadCell();
      }
    }
  }

  public RectangularBoard (String configInitial, Integer rows, Integer cols, List<Rule> rules) {
    this.rows = rows;
    this.cols = cols;
    this.rules = rules;
    board = new Cell[rows][cols];
    configInitial(configInitial);
  }

  private void configInitial(String config){
    int count = 0;
    int x = 0;
    int y = 0;
    while (count < config.length()-1) {
      if (config.charAt(count) != '\n') {
        char character = config.charAt(count);
        if (CellFactoryForBoard.correctCell(character)) {
          CellFactory cellFactory = CellFactoryForBoard.cellFactory(character);
          board[x][y] = cellFactory.createCell();
          y++;
        }
      } else {
        y=0;
        x++;
      }
      count++;
    }
  }

  @Override
  public Board nextBoard () {
    RectangularBoard newBoard = new RectangularBoard(rows, cols, rules);
    for (int x = 0; x < rows; x++) {
      for (int y = 0; y < cols; y++) {
        for (Rule rule : rules) {
          List<Cell> neighbors = calculateNeighbors(x, y);
          Cell cell = board[x][y];
          if (rule.validate(cell, neighbors)) {
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
    for (int x = 0; x < rows; x++) {
      for (int y = 0; y < cols; y++) {
        res += board[x][y].toString();
        res += " ";
      }
      res += "\n";
    }
    return res;
  }

}
