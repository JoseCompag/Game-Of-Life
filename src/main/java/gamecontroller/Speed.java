package gamecontroller;

import board.Board;
import output.Observer;

import java.util.ArrayList;

public class Speed extends GameController {

  private Integer generationMax = 5000;


  public Speed(Board board, Integer time) {
    this.board = board;
    this.time = time;
    observers = new ArrayList<Observer>();
  }

  @Override
  public void start() {

    generation = 0;
    notifyObservers();

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
