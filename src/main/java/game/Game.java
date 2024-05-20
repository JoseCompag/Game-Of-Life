package game;

import board.Board;
import output.Observer;
import rule.Rule;

import java.util.ArrayList;
import java.util.List;

public class Game extends Subject {

  private Board board;
  private List<Rule> rules;
  private Integer generation;

  public Game (Board board, List<Rule> rules) {
    observers = new ArrayList<Observer>();
    this.board = board;
    this.rules = rules;
  }

  public void start() {
    generation = 0;
    while (generation < 100) {
      this.board = board.nextBoard (this.rules);
      generation++;
      notifyObservers();
    }
  }

  @Override
  public void notifyObservers() {
    for (Observer o : observers) {
      o.update (board, generation);
    }
  }

}
