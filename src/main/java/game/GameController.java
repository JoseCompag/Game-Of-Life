package game;

import board.Board;
import output.Observer;

import java.util.ArrayList;

public class GameController extends Subject {

  private Board board;
  private Integer generation;

  public GameController() {}

  public GameController(Board board) {
    observers = new ArrayList<Observer>();
  }

  public void setBoard(Board board) {
    this.board = board;
  }

  public Board getBoard() {
    return board;
  }

  public void start (Integer generationMax) {
    generation = 0;
    do {
      this.board = board.nextBoard ();
      generation++;
      notifyObservers();
    } while (generation < generationMax);
  }

  @Override
  public void notifyObservers() {
    for (Observer o : observers) {
      o.update (board, generation);
    }
  }

}