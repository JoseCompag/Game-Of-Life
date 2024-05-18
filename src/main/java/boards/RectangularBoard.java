package boards;

import cells.Cell;
import cells.DeadCell;
import rules.Rule;

import java.util.ArrayList;
import java.util.List;

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

  public RectangularBoard(Cell[][] board){
    this.board = board;
  }

  @Override
  public Board newBoard(List<Rule> rules) {
    setNeighbors();
    Cell[][] newRectangularBoard = new Cell[width][height];
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        Cell cell = board[x][y];
        for(Rule rule : rules){
          if(rule.validate(cell)){
            newRectangularBoard[x][y] = rule.applyRule();
            break;
          }
        }
      }
    }
    return new RectangularBoard(newRectangularBoard);
  }


  private void setNeighbors() {
    ArrayList<Cell> aux;

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        aux = calculateNeighbors(x, y);
        board[x][y].setNeighbors(aux);
      }
    }
  }

  private ArrayList<Cell> calculateNeighbors(int x, int y) {
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
