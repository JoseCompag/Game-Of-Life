package game;

import board.Board;
import output.Observer;
import rule.Rule;

import java.util.ArrayList;
import java.util.List;

public class Game extends Subject {

  private Board board;
  private Integer generation;

  public Game (Board board) {
    observers = new ArrayList<Observer>();
    this.board = board;
  }

  public void start() {
    generation = 0;
    do {
      this.board = board.nextBoard ();
      generation++;
      notifyObservers();
    }while (generation < 25);
  }

  @Override
  public void notifyObservers() {
    for (Observer o : observers) {
      o.update (board, generation);
    }
  }

}
