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

  public Board getBoard() {
    return board;
  }

  public void start(Integer generationMax) {
    generation = 0;
    do {
      this.board = board.nextBoard ();
      generation++;
      notifyObservers();
    }while (generation < generationMax);
  }

  @Override
  public void notifyObservers() {
    for (Observer o : observers) {
      o.update (board, generation);
    }
  }

}
