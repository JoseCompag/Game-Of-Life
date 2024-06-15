package gamecontroller;

import board.Board;
import output.Observer;

import java.util.ArrayList;

public class StartDelimited extends GameController{

  public StartDelimited(Board board, Integer generationMax){
    this.generationMax = generationMax;
    this.board = board;
    observers = new ArrayList<Observer>();
  }

  @Override
  public void start() {
    generation = 0;
    do {
      this.board = board.nextBoard ();
      generation++;
      notifyObservers();
    } while (generation < generationMax);
  }
}
