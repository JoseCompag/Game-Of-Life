package board;

import cell.*;
import rule.Rule;

import java.util.HashMap;

public class RectangularBoard extends Board {

  private Cell[][] board;
  private int rows;
  private int cols;
  private CellFactory cellFactory;

  public RectangularBoard (int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    board = new Cell[rows][cols];
    for (int x = 0; x < rows; x++) {
      for (int y = 0; y < cols; y++) {
        board[x][y] = new DeadCell();
      }
    }
  }

  public RectangularBoard (int rows, int cols, String configInitial, CellFactory cellFactory) {
    this.rows = rows;
    this.cols = cols;
    this.cellFactory = cellFactory;
    board = new Cell[rows][cols];
    loadInitialConfig(configInitial);
  }

  @Override
  public Board nextBoard () {
    RectangularBoard newBoard = new RectangularBoard(rows, cols);
    newBoard.setRules(this.rules);
    for (int x = 0; x < rows; x++) {
      for (int y = 0; y < cols; y++) {
        for (Rule rule : rules) {
          HashMap<Class<?>, Integer> neighbors = calculateNeighbors(x, y);
          Cell cell = board[x][y];
          if (rule.validate(cell, neighbors)) {
            newBoard.setCell(x,y,rule.apply(cell, neighbors));
            break;
          }
        }
      }
    }
    return newBoard;
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

  private void loadInitialConfig (String config) {
    int count = 0;
    int x = 0;
    int y = 0;
    while (count < config.length()-1) {
      if (config.charAt(count) != '\n') {
        char character = config.charAt(count);
        if (character != ' ' && character != '\r') {
          board[x][y] = cellFactory.createCell(character);
          y++;
        }
      } else {
        y=0;
        x++;
      }
      count++;
    }
  }

  private void setCell (int x, int y, Cell cell) {
    board[x][y] = cell;
  }

  private HashMap<Class<?>, Integer> calculateNeighbors (int x, int y) {
    HashMap<Class<?>, Integer> neighbors = new HashMap<>();
    for (int i = x-1; i <= x+1; i++) {
      for (int j = y-1; j <= y+1; j++) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && (i != x || j != y)) {
          Class<? extends Cell> currentCellClass = board[i][j].getClass();
          if(neighbors.containsKey(currentCellClass)){
            Integer newValueCurrentCellClass = neighbors.get(currentCellClass)+1;
            neighbors.put(currentCellClass, newValueCurrentCellClass);
          }else{
            neighbors.put(currentCellClass, 1);
          }
        }
      }
    }
    return neighbors;
  }
}
