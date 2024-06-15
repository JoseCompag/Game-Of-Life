package gamecontroller;

import board.Board;
import output.Observer;

import java.util.ArrayList;

public class TimeSpeed extends GameController {

  private Integer time;

  public TimeSpeed (Board board, Integer time) {
    this.board = board;
    this.time = time;
    observers = new ArrayList<Observer>();
  }

  @Override
  public void start() {
    generation = 0;
    do {
      this.board = board.nextBoard ();
      generation++;
      notifyObservers();
      try {
        Thread.sleep(time);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

    } while (generation < generationMax);
  }
}
