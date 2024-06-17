package gamecontroller;

import board.Board;
import output.Observer;

import java.util.ArrayList;

public class Speed extends GameController {

  private Integer generationMax = 5000;
  private Integer time;

  public Speed(Board board, Integer time) {
    this.board = board;
    this.time = time;
    observers = new ArrayList<Observer>();
  }

  @Override
  public void start() {

    generation = 0;
    System.out.print("\033[H\033[2J");
    System.out.flush();
    String print = board.toString();
    System.out.println("---"+generation+"---");
    System.out.println(print);
    generation++;

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
