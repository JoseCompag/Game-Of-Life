package gamecontroller;

import board.Board;
import output.Observer;

public abstract class GameController extends Subject{

  protected Board board;
  protected Integer generation;
  protected Integer generationMax = 200;


  public void setBoard (Board board) {
    this.board = board;
  }

  public abstract void start();

  public Board getBoard() {
    return board;
  }

  @Override
  public void notifyObservers() {
    for (Observer o : observers) {
      o.update (board, generation);
    }
  }
}
