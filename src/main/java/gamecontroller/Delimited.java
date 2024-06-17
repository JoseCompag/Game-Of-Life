package gamecontroller;

import board.Board;
import output.Observer;

import java.util.ArrayList;

public class Delimited extends GameController {

  private Integer generationMax;

  public Delimited(Board board, Integer generationMax) {
    this.generationMax = generationMax;
    this.board = board;
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
    } while (generation < generationMax);
  }

}
