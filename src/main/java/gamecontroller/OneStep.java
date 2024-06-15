package gamecontroller;

import board.Board;
import output.Observer;

import java.util.ArrayList;
import java.util.Scanner;

public class OneStep extends GameController {

  public OneStep(Board board) {
    this.board = board;
    observers = new ArrayList<Observer>();
  }

  @Override
  public void start() {
    generation = 0;
    Scanner scanner = new Scanner(System.in);
    boolean bool = true;
    do {
      this.board = board.nextBoard ();
      generation++;
      notifyObservers();
      String input = scanner.nextLine();
      if (!input.isEmpty()) {
        bool = false;
      }
    } while (bool);
  }
}
