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

  public void setGeneration(Integer generation) {
    this.generation = generation;
  }

  public void start() {
    int count = 1;
    do {
      this.board = board.nextBoard ();
      count++;
      notifyObservers();
    }while (count <= generation);
  }

  @Override
  public void notifyObservers() {
    for (Observer o : observers) {
      o.update (board, generation);
    }
  }

}
