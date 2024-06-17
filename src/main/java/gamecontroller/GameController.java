package gamecontroller;

import board.Board;
import output.Observer;

public abstract class GameController extends Subject {

  protected Board board;
  protected Integer generation;

  public abstract void start();

  public void setBoard (Board board) {
    this.board = board;
  }

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
